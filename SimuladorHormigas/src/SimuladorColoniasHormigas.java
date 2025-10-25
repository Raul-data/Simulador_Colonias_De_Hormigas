import java.util.HashMap;
import java.util.Random;

/**
 * Clase principal del simulador de colonias de hormigas.
 * Proporciona la lógica central para gestionar la simulación de hormigas.
 * <p>
 * Esta clase controla:
 * - Gestión del HashMap de hormigas.
 * - Control de movimiento con verificación de límites.
 * - Actualización de la visualización.
 * - Manejo de hilos y sincronización.
 */
public class SimuladorColoniasHormigas {

    // Constantes de configuración
    /**
     * Número total de hormigueros en la simulación.
     */
    private static final int NUMERO_HORMIGUERO = 5;
    /**
     * Intervalo de actualización en milisegundos.
     */
    private static final int INTERVALO_ACTUALIZACION = 1000;
    /**
     * Arreglo de direcciones posibles para el movimiento de hormigas: {derecha, abajo, arriba, izquierda}.
     */
//    private static final int[][] DIRECCIONES = {
//            {0, 1},  // Derecha
//            {1, 0},  // Abajo
//            {-1, 0}, // Arriba
//            {0, -1}  // Izquierda
//    };

    // Atributos
    /**
     * Mapa que representa el entorno de la simulación.
     */
    private Mapa mapa;
    /**
     * HashMap que almacena todas las hormigas activas con su ID como clave.
     */
    private HashMap<String, Hormiga> hormigas;
    /**
     * Estado de la simulación, controlado con modificadores volátiles para hilos.
     */
    private volatile boolean simulacionActiva;
    /**
     * Generador de números aleatorios para movimientos y posiciones.
     */
    private final Random random;

    /**
     * Constructor de la clase SimuladorColoniasHormigas.
     * <p>
     * Inicializa el mapa, el HashMap de hormigas, el estado de la simulación y el generador aleatorio.
     */
    // creamos el constructor
    // 0(1) -> no recorre ninguna estructura solo inicializa los atributos
    public SimuladorColoniasHormigas() {
        this.mapa = new Mapa();
        this.hormigas = new HashMap<>();
        this.simulacionActiva = false;
        this.random = new Random();
    }


    /**
     * Verificamos si una posicion esta ocupada por otra hormiga
     * <p>
     * Este metodo es sincronizado para evitar que multiples hormigas intenten moverse simultaneamente
     * @param posicion
     * @param idHormigaActual
     * @return
     */
    public synchronized boolean posicionOcupada(Posicion posicion, String idHormigaActual){
        for (Hormiga hormiga : hormigas.values()){
            //No comparar con la misma hormiga
            if(hormiga.getIdHormiga().equals(idHormigaActual)){
                continue;
            }

            //Verificar si la otra hormiga esta en esa posicion
            Posicion posHormiga = hormiga.getPosicion();
            if (posHormiga.getX() == posicion.getX() && posHormiga.getY() == posicion.getY()){
                return true; //Posicion ocupada
            }
        }
        return false; //Posicion libre
    }

    /**
     * Genera hormigas obreras y LAS INICIA COMO HILOS.
     * <p>
     * IMPORTANTE: Aquí se llama a start() que lanza el run() de cada hormiga.
     */
    // Creamos los metodos
    // metodo generar hormigas obreras y las iniciamos con hilos
    public void generarHormigaObrera() {
        System.out.println("\n---- Generando " + NUMERO_HORMIGUERO + " Hormigas obreras ----\n");

        // Creamos el bucle para generar las hormigas una a una
        for (int i = 0; i < NUMERO_HORMIGUERO; i++) {

            //Generar posicion aleatoria evitando el hormiguero
            Posicion posicionInicial;
            do{
                int x = random.nextInt(Mapa.ANCHO);
                int y = random.nextInt(Mapa.ALTO);
                posicionInicial = new Posicion(x, y);
            }while (posicionInicial.getX() == mapa.getHormiguero().getX() && posicionInicial.getY() == mapa.getHormiguero().getY());

            // Creamos el identificador unico para cada hormiga
            String id = "OBRERA_" + (i + 1);

            // creamos nueva hormiga obrera con su ID y su posicion inical
            Hormiga obrera = new HormigaObrera(id, posicionInicial);

            //Asignamos referencia al mapa
            obrera.setMapa(mapa);

            //asignamos referencia al simulador
            obrera.setSimulador(this);

            // La agregamos al hasmap
            hormigas.put(id, obrera);

            //Iniciar el hilo (llamamos con esto al run())
            obrera.start();

            // que nos muestre la informacion de las hormigas creadas
            System.out.println("Hormiga creada: " + obrera.toString());
        }
        // Mostramos el resumen final de las hormigas mostradas
        System.out.println("\nSe han generado " + hormigas.size() + " hormigas obreras.\n");

        // llamamos actualizarVisualizacion para refrescar el mapa
        actualizarVisualizacion();
    }

    /**
     * Ejecuta la simulación.
     * <p>
     * Este método contiene la lógica principal de la simulación, pero actualmente está vacío.
     */
    // metodo que ejecuta la simulacion
    public void ejecutar() {
        System.out.println("||||| INICIO DE SIMULACION |||||");

        //generar las hormigas obreras
        generarHormigaObrera();

        //Mostramos el estado inicial
        System.out.println("---Estado inicial---");
        actualizarVisualizacion();

        // Esperar 2 segundos antes de empezar las iteraciones
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            System.err.println("Error al esperar: " + e.getMessage());
        }

        //Activar la simulacion
        simulacionActiva = true;

        //Bucle principal de simulacion
        int iteracion = 0;
        int iteracionesMinimas = 10;

        System.out.println("\nLas hormigas se estan moviendo independientemente");


        while (simulacionActiva && iteracion < iteracionesMinimas){ //Ponemos 10 iteraciones como ejemplo
            try{

                // Solo actulizar la visualizacion ya que las hormigas se mueven solas en sus hilos
                actualizarVisualizacion();

                //Mostramos el numero de iteraciones
                System.out.println("Iteracion: " + (iteracion + 1) + " de " + iteracionesMinimas + "\n");

                //Esperamos antes de la siguiente actualizacion
                Thread.sleep(INTERVALO_ACTUALIZACION);

                iteracion++;

            }catch (InterruptedException e){
                System.err.println("Error en la simulacion: " + e.getMessage());
                break;
            }

        }

        // no detenemos la simulación aquí - las hormigas siguen vivas
        System.out.println("\n✓ Iteraciones mínimas completadas (" + iteracion + " iteraciones)");
        System.out.println("Las hormigas siguen moviéndose...\n");

    }

    /**
     * Metodo publico para continuar iteraciones adicionales usado desde el main cuando el usuario quiera continuar
     */
    public void continuarIteracion(int numIteraciones){
        System.out.println("\n--- Continuando con " + numIteraciones + " iteraciones más ---\n");

        for(int i = 0; i < numIteraciones; i++){
            try{
                actualizarVisualizacion();
                System.out.println("Iteracion: " + (i + 1) + " de " + numIteraciones + "\n");
                Thread.sleep(INTERVALO_ACTUALIZACION);
            }catch (InterruptedException e){
                System.err.println("Error durante iteraciones extra: " + e.getMessage());
                break;
            }
        }

        System.out.println("\nIteraciones extras completadas");
    }

    /**
     * Detiene la simulación y todos los hilos de hormigas
     */
    // metodo detener la simulacion
    public void detenerSimulacion() {
        System.out.println("\n--- Simulacion detenida ---");
        simulacionActiva = false;

        // Detener todas las hormigas
        for (Hormiga hormiga : hormigas.values()){
            hormiga.detener();
        }

        //Esperar a que terminen
        for(Hormiga hormiga : hormigas.values()){
            try{
                hormiga.join(1000); // Esperar maximo 1 segundo por cada hormmiga
            }catch (InterruptedException e){
                System.err.println("Error al esperar hormiga: " + e.getMessage());
            }
        }

        System.out.println("Simulacion detenida todos los hilos finalizados\n");
    }

    /**
     * Actualiza la visualización del mapa de forma periódica.
     * <p>
     * Limpia la consola, prepara el mapa con las posiciones de las hormigas y muestra las estadísticas.
     */
    // metodo que actualiza la visualizacion del mapa periodicamente
    private void actualizarVisualizacion() {
        limpiarConsola();
        mapa.prepararMapa(hormigas);
        mapa.mostrarMapa();
        mostrarEstadisticas();
    }


    /**
     * Limpia la consola para actualizar la visualización.
     * <p>
     * Imprime varias líneas en blanco para simular un borrado de pantalla.
     */
    // metodo para limpiar consola
    private void limpiarConsola() {
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    /**
     * Muestra las estadísticas de la simulación.
     * <p>
     * Incluye el número de hormigas activas, el intervalo de actualizaciones y la posición del hormiguero.
     */
    // metodo para mostrar las estadisticas de la simulacion
    // 0(1)
    private void mostrarEstadisticas() {
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Intervalo de actualizaciones: " + INTERVALO_ACTUALIZACION);
        System.out.println("Hormiguero en: X = " + mapa.getHormiguero().getX() + " Y = " + mapa.getHormiguero().getY());
        System.out.println("Estado: " + (simulacionActiva ? "ACTIVA" : "INACTIVA"));
    }
}
/**
 * Clase principal del simulador de colonias de hormigas.
 * Proporciona la lógica central para gestionar la simulación de hormigas.
 * <p>
 * Esta clase controla:
 * - Gestión del HashMap de hormigas.
 * - Control de movimiento con verificación de límites.
 * - Actualización de la visualización.
 * - Manejo de hilos y sincronización.
 *
 */
import java.util.HashMap;
import java.util.Random;

public class SimuladorColoniasHormigas {

    // Constantes de configuración
    /** Número total de hormigueros en la simulación. */
    private static final int NUMERO_HORMIGUERO = 5;
    /** Intervalo de actualización en milisegundos. */
    private static final int INTERVALO_ACTUALIZACION = 100;
    /** Arreglo de direcciones posibles para el movimiento de hormigas: {derecha, abajo, arriba, izquierda}. */
    private static final int[][] DIRECCIONES = {
            {0, 1},  // Derecha
            {1, 0},  // Abajo
            {-1, 0}, // Arriba
            {0, -1}  // Izquierda
    };

    // Atributos
    /** Mapa que representa el entorno de la simulación. */
    private Mapa mapa;
    /** HashMap que almacena todas las hormigas activas con su ID como clave. */
    private HashMap<String, Hormiga> hormigas;
    /** Estado de la simulación, controlado con modificadores volátiles para hilos. */
    private volatile boolean simulacionActiva;
    /** Generador de números aleatorios para movimientos y posiciones. */
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
     * Genera hormigas obreras y las coloca en el mapa.
     * <p>
     * Crea un número fijo de hormigas obreras (definido por NUMERO_HORMIGUERO) con posiciones aleatorias
     * dentro de los límites del mapa y las agrega al HashMap de hormigas.
     */
    // Creamos los metodos
    // metodo generar hormigas obreras y colocarlas en el mapa
    // 0(n)
    public void generarHormigaObrera() {
        int numeroHormiga = NUMERO_HORMIGUERO; // Numero total de hormigas obrearas para crear

        // Creamos el bucle para generar las hormigas una a una
        for (int i = 0; i < numeroHormiga; i++) {

            // Generamos posiciones aleatorias dentro de los limites del mapa
            // 0(1) -> solo estamos generando numeros aleatorios
            int x = random.nextInt(Mapa.ANCHO);
            int y = random.nextInt(Mapa.ALTO);

            Posicion posicionInicial = new Posicion(x, y); // creamos la nueva posicion con esas cordenadas previas

            // Creamos el identificador unico para cada hormiga
            String id = "OBRERA_" + (i + 1);

            // creamos nueva hormiga obrera con su ID y su posicion inical
            Hormiga obrera = new HormigaObrera(id, posicionInicial);

            // La agregamos al hasmap
            hormigas.put(id, obrera);

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
        // por ahora vacio
    }

    /**
     * Detiene la simulación.
     * <p>
     * Cambia el estado de la simulación a inactiva.
     */
    // metodo detener la simulacion
    // 0(1)
    public void detenerSimulacion() {
        simulacionActiva = false;
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
     * Mueve todas las hormigas en el simulador.
     * <p>
     * Este método es sincronizado para evitar conflictos en el acceso concurrente.
     * Actualmente está vacío.
     */
    // metodo mueve todas las hormigas
    private synchronized void moverTodasLasHormigas() {
        // por ahora lo dejamos vacio
    }

    /**
     * Mueve una hormiga de forma aleatoria.
     * <p>
     * Selecciona una dirección aleatoria y actualiza la posición de la hormiga.
     * Este método es sincronizado para evitar conflictos.
     * Actualmente está vacío.
     *
     * @param hormiga La hormiga a mover.
     */
    // metodo mueve una hormiga aleatoriamente
    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga) {
        // por ahora lo dejamos vacio
    }

    /**
     * Limpia la consola para actualizar la visualización.
     * <p>
     * Imprime varias líneas en blanco para simular un borrado de pantalla.
     */
    // metodo para limpiar consola
    private void limpiarConsola() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
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
/*Clase principal del simulador de colonia de hormigas
 Esta clase controla toda la lógica del simulador, incluyendo:
 Gestión del HashMap de hormigas
 Control de movimiento con verificación de límites
 Actualización de la visualización
 Manejo de hilos y sincronización*/

import java.util.HashMap;
import java.util.Random;

public class SimuladorColoniasHormigas {
    //constantes de configuracion
    private static final int NUMERO_HORMIGUERO = 5,INTERVALO_ACTUALIZACION = 100;

    private static final int[][] DIRECCIONES = {
        {0,1}, //derecha
        {1,0}, //abajo
        {-1,0}, //arriba
        {0,-1} //izquierda
    };

    //Creamos los atributos
    private Mapa mapa; // Mapa del simulador
    private HashMap<String, Hormiga> hormigas; //Todas las hormigas activas
    private volatile boolean simulacionActiva; //estado de la simulacion
    private final Random random; //generador aleatorio


    //creamos el constructor
    //0(1)-> no recorre ninguna estructura solo inicializa los atributos
    public SimuladorColoniasHormigas() {
        this.mapa = new Mapa();
        this.hormigas = new HashMap<>();
        this.simulacionActiva = false;
        this.random = new Random();
    }

    //Creamos los metodos
    //metodo generar hormigas obreras y colocarlas en el mapa
    //0(n)
    public void generarHormigaObrera(){
        int numeroHormiga = NUMERO_HORMIGUERO; //Numero total de hormigas obrearas para crear

        //Creamos el bucle para generar las hormigas una a una
        for (int i = 0; i < numeroHormiga; i++) {

            //Generamos posiciones aleatorioas dentro de los limites del mapa
            //0(1) -> solo estamos generando numeros aleatorios
            int x = random.nextInt(Mapa.ANCHO);
            int y = random.nextInt(Mapa.ALTO);

            Posicion posicionInicial = new Posicion(x, y); // creamos la nueva posicion con esas cordenadas previas

            //Creamos el identificador unico para cada hormiga
            String id = "OBRERA_" + (i + 1);

            //creamos nueva hormiga obrera con su ID y su posicion inical
            Hormiga obrera = new HormigaObrera(id,posicionInicial);

            //La agregamos al hasmap
            hormigas.put(id, obrera);

            //que nos muestre la informacion de las hormigas creadas
            System.out.println("Hormiga creada: " + obrera.toString());


        }
        //Mostramos el resumen final de las hormigas mostradas
        System.out.println("\nSe han generado " + hormigas.size() + " hormigas obreras.\n");

        //llamamos actualizarVisualizacion para refrescar el mapa
        actualizarVisualizacion();
    }

    //metodo que ejecuta la simulacion
    public void ejecutar(){
        //por ahora vacio
    }

    //metodo detener la simulacion
    //0(1)
    public void detenerSimulacion(){
        simulacionActiva = false;
    }

    //metodo que actualiza la visualizacion del mapa periodicamente
    private void actualizarVisualizacion(){
        limpiarConsola();
        mapa.prepararMapa(hormigas);
        mapa.mostrarMapa();
        mostrarEstadisticas();
    }

    //metodo mueve todas las hormigas
    private synchronized void moverTodasLasHormigas(){
        //por ahora lo dejamos vacio
    }

    //metodo mueve una hormiga aleatoriamente
    private synchronized void moverHormigaAleatoriamente(Hormiga hormiga){
        //por ahora lo dejamos vacio
    }

    //metodo para limpiar consola
    private void limpiarConsola(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }

    //metodo para mostrar las estadisticas de la simulacion
    //0(1)
    private void mostrarEstadisticas(){
        System.out.println("Hormigas activas: " + hormigas.size());
        System.out.println("Intervalo de actualizaciones: " + INTERVALO_ACTUALIZACION);
        System.out.println("Hormiguero en: X = " + mapa.getHormiguero().getX() +  " Y = " + mapa.getHormiguero().getY());
        System.out.println("Estado: " + (simulacionActiva ? "ACTIVA" : "INACTIVA"));
    }

}

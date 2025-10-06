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
    public void generarHormigaObrera(){
        //Lo implementamos mas tarde
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
        //por ahora lo dejamos vacio
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
    }

}

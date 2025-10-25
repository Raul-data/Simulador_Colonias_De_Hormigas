
import java.util.Random;

/**
 * Clase abstracta que representa una hormiga en el simulador.
 * <p>
 * Esta clase define las propiedades y comportamientos básicos de una hormiga,
 * incluyendo su identificación, tipo, posición y estado. Extiende Thread para
 * permitir la ejecución concurrente y sirve como base para tipos específicos
 * de hormigas (OBRERA, GUERRERA, REINA).
 */
public abstract class Hormiga extends Thread {
    // Creamos los atributos
    /**
     * Identificador único de la hormiga.
     */
    protected final String id; // identificador unico de la hormiga
    /**
     * Tipo de hormiga (OBRERA, GUERRERA, REINA).
     */
    protected final TipoHormiga tipo; // Tipo de hormiga (OBRERA,GUERRERA,REINA)
    /**
     * Posición actual de la hormiga en el mapa, modificable de forma segura.
     */
    protected volatile Posicion posicion; // Posicion actual de la hormiga en el mapa
    /**
     * Estado activo/inactivo de la hormiga, controlado con modificadores volátiles.
     */
    protected volatile boolean activa; // estado activo/inactivo de la hormiga
    /**
     * Generador aleatorio para comportamientos de la hormiga.
     */
    protected final Random random; // generador aleatorio para comportamientos
    /**
     * Referencia al mapa para verificar límites y hormiguero.
     */
    protected Mapa mapa; //Añadimos el atributo mapa
    /**
     * Referenciamos al simulador para verificar colisiones
     */
    protected SimuladorColoniasHormigas simulador;

    // Creamos las direcciones posibles de movimiento
    /**
     * Arreglo de direcciones posibles para el movimiento: {derecha, abajo, arriba, izquierda}.
     */
    protected static final int[][] DIRECCIONES = {
            {0, 1}, // derecha
            {1, 0}, // abajo
            {-1, 0}, // arriba
            {0, -1} // izquierda
    };

    /**
     * Constructor de la clase Hormiga.
     * <p>
     * Inicializa los atributos de la hormiga con un identificador único, tipo,
     * posición inicial y configura el estado activo y el generador aleatorio.
     *
     * @param id              Identificador único de la hormiga.
     * @param tipo            Tipo de hormiga (OBRERA, GUERRERA, REINA).
     * @param posicionInicial Posición inicial de la hormiga en el mapa.
     */
    // Creamos el constructor Hormiga
    // 0(1)
    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial) {
        this.id = id;
        this.tipo = tipo;
        this.posicion = posicionInicial;
        this.random = new Random();
        this.activa = true;
        this.mapa = null; // se asiganara desde el simulador
        this.simulador = null;
    }

    /**
     * Establece la referencia del mapa
     * <p>
     * necesario para que la hormiga pueda verificar limites y el hormiguero
     *
     * @param mapa El mapa del simulador
     */
    public void setMapa(Mapa mapa){
        this.mapa = mapa;
    }

    /**
     * Establecemos la referencia al simulador
     * lo necesitamos ya que de esta mnera verificamos si una posicion esta ocupada por otra hormiga
     */
    public void setSimulador(SimuladorColoniasHormigas simulador){
        this.simulador = simulador;
    }

    /**
     * Obtiene el identificador único de la hormiga.
     * <p>
     * Devuelve el ID asignado a la hormiga.
     *
     * @return El ID de la hormiga.
     */
    // creamos los Getters
    // 0(1)
    public String getIdHormiga() {
        return id;
    }

    /**
     * Obtiene el tipo de la hormiga.
     * <p>
     * Devuelve el tipo de hormiga (OBRERA, GUERRERA, REINA).
     *
     * @return El tipo de hormiga.
     */
    public TipoHormiga getTipo() {
        return tipo;
    }

    /**
     * Obtiene la posición actual de la hormiga.
     * <p>
     * Devuelve la posición actual en el mapa.
     *
     * @return La posición actual.
     */
    public Posicion getPosicion() {
        return posicion;
    }

    /**
     * Actualiza la posición de la hormiga.
     * <p>
     * Establece una nueva posición para la hormiga.
     *
     * @param nuevaPosicion La nueva posición a establecer.
     */
    // creamos el setters solo de la posicion
    // 0(1)
    public void setPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    /**
     * Verifica si la hormiga está activa.
     * <p>
     * Devuelve el estado actual de la hormiga.
     *
     * @return `true` si está activa, `false` si no.
     */
    // verificamos que la hormiga esta activa
    // 0(1)
    public boolean isActiva() {
        return activa;
    }

    /**
     * Detiene la actividad de la hormiga de forma segura.
     * <p>
     * Cambia el estado de la hormiga a inactivo.
     */
    // DEtener a la hormiga de forma segura
    // 0(1)
    public void detener() {
        activa = false;
    }

    /**
     * Método run para la ejecución del hilo de la hormiga.
     * <p>
     * Implementacion con hilos:
     * -Cada hormiga se mueve de forma independiente
     * -duerme entre 0 y 5 segundos entre movimiento
     * -Verifica limites del mapa y evita el hormiguero
     * -se ejecuta mientras la hormiga este activa
     */
    // Metodo run para hilos - MOVIMIENTO INDEPENDIENTE
    // 0(n) -> depende de cuánto tiempo esté activa
    @Override
    public void run() {
        //Verificamos que tenemos referencia al mapa
        if(mapa == null || simulador == null){
            System.err.println("Error: " + id + " no tiene referencia al mapa");
            return;
        }

        //Bucle principal: mientras la hormiga este activa
        while(activa){
            try{
                // 1. Dormir entre 0 y 5 segundos (de 0-5000 milisegundos)
                int tiempoSleep = random.nextInt(5001);
                Thread.sleep(tiempoSleep);

                // 2. Mover la hormiga aleatoriamente
                moverAleatoriamente();

            }catch (InterruptedException e){
                //Si el hilo es interrumpido
                System.out.println(id + " fue interrumpido");
                activa = false;
                break;
            }
        }

        System.out.println(id + " ha terminado su ejecucion");
    }


    /**
     * Mueve la hormiga aleatoriamente verificando limites
     * <p>
     * MEtodo privado que implementa la logica de movimiento:
     * -Elige una direccion aleatoria
     * -Calcula nueva posicion
     * -Verifica limites del mapa
     * -verifica que no sea el hormiguero
     * -Actualiiza posicion si es valida
     */
    //Metodo para mover la hormiga aleatoriamente
    //0(1)
    private void moverAleatoriamente(){
        //1 . elegir direccion aleatoria
        int indice = random.nextInt(DIRECCIONES.length);
        int[] direccion  = DIRECCIONES[indice];

        // 2. Calcular nueva posicion
        Posicion nuevaPosicion = posicion.mover(direccion[0], direccion[1]);

        // 3. Verificar que esta dentro de limites
        if (!mapa.dentroLimites(nuevaPosicion)){
            return; // fuera de limites no se mueve
        }

        // 4. verificamos que no es el hormiguero
        Posicion hormiguero = mapa.getHormiguero();
        if (nuevaPosicion.getX() == hormiguero.getX() && nuevaPosicion.getY() == hormiguero.getY()){
            return;
        }

            // 5. Verificar que no hay otra hormiga en esa posicion
        if (simulador.posicionOcupada(nuevaPosicion, this.id)){
            return; // Posicion ocupada no se mueve
        }

        // 6. Mover(La posicion esta libre)
        this.posicion = nuevaPosicion;
    }

    /**
     * Devuelve una representación en cadena de la hormiga.
     * <p>
     * Incluye el ID, tipo, símbolo y posición de la hormiga para facilitar su visualización.
     *
     * @return Una cadena con la información de la hormiga.
     */
    // Creamos el metodo toString para mostrar informacion que se pueda entender a la hora de mostrar las hormigas creadas
    @Override
    public String toString() {
        return "Hormigas ID: " + id +
                " | Tipo: " + tipo.getNombre() +
                " | Simbolo: " + tipo.getSimbolo() +
                " | Posicion: (" + posicion.getX() + ", " + posicion.getY() + ")";
    }
}

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
     * Define el comportamiento concurrente de la hormiga, actualmente vacío.
     */
    // creamos el metodo run para hilos (Por ahora vacio)
    @Override
    public void run() {
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
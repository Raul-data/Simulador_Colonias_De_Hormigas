/**
 * Clase que representa una hormiga obrera en el simulador.
 * <p>
 * Esta clase extiende Hormiga y define específicamente el comportamiento de una hormiga obrera,
 * inicializándola con un identificador y una posición inicial. Utiliza la herencia para
 * aprovechar los atributos y métodos de la clase base Hormiga.
 *
 */
public class HormigaObrera extends Hormiga {
    /**
     * Constructor de la clase HormigaObrera.
     * <p>
     * Inicializa una hormiga obrera con un identificador único y una posición inicial,
     * llamando al constructor de la clase padre Hormiga con el tipo OBRERA.
     *
     * @param id Identificador único de la hormiga obrera.
     * @param posicionInicial Posición inicial de la hormiga obrera en el mapa.
     */
    // Creamos el constructor, que recibe el id y la posición donde nace la obrera
    // 0(1)
    public HormigaObrera(String id, Posicion posicionInicial) {
        super(id, TipoHormiga.OBRERA, posicionInicial); // de esta manera hacemos la llamada al constructor padre
    }

    /**
     * Método run para la ejecución del hilo de la hormiga obrera.
     * <p>
     * Define el comportamiento concurrente de la hormiga obrera, actualmente vacío.
     */
    // Metodo run vacio
    @Override
    public void run() {
        // por ahora no le metemos nada son hilos
    }
}
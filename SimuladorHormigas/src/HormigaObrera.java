/**
 * Clase que representa una hormiga obrera en el simulador.
 * <p>
 * Esta clase extiende Hormiga y define específicamente el comportamiento de una hormiga obrera,
 * inicializándola con un identificador y una posición inicial. Utiliza la herencia para
 * aprovechar los atributos y métodos de la clase base Hormiga.
 */
public class HormigaObrera extends Hormiga {
    /**
     * Constructor de la clase HormigaObrera.
     * <p>
     * Inicializa una hormiga obrera con un identificador único y una posición inicial,
     * llamando al constructor de la clase padre Hormiga con el tipo OBRERA.
     *
     * @param id              Identificador único de la hormiga obrera.
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
     * Por ahora vacío. El comportamiento de movimiento se implementa en la clase padre Hormiga.
     */
    // Metodo run vacío (no es para ahora)
    @Override
    public void run() {
        // Vacío - el comportamiento está en Hormiga.run()
    }

    /**
     * Método toString heredado y personalizado para HormigaObrera.
     * <p>
     * Devuelve una representación en cadena específica de la hormiga obrera.
     *
     * @return Una cadena con la información de la hormiga obrera.
     */
//    @Override
//    public String toString() {
//        return "HormigaObrera{" +
//                "id='" + id + '\'' +
//                ", posicion=" + "(" + posicion.getX() + ", " + posicion.getY() + ")" +
//                ", activa=" + activa +
//                '}';
//    }
}
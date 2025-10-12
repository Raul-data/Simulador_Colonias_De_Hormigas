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
     * Define el comportamiento concurrente de la hormiga obrera.
     * Este método se ejecutará cuando la hormiga se inicie como hilo.
     * <p>
     * NOTA: Por ahora está preparado pero no se utiliza activamente.
     * El movimiento actual lo controla SimuladorColoniasHormigas.moverTodasLasHormigas().
     * <p>
     * Cuando se active el sistema de hilos completo, este método:
     * - Hará que la hormiga se mueva de forma autónoma
     * - Funcionará independientemente de las otras hormigas
     * - Se ejecutará en su propio hilo
     */
    // Metodo run para hilos
    @Override
    public void run() {
        //Bucle principal mientras la hormiga este activa
        while (activa){
            try{
                /*Comportamiento de la hormiga obrera:
                Las obreras exploran el mapa de forma autonoma
                */
                //1. esperar un tiempo aleatorio entre movimientos
                // tiempo entre 500 ms y 1500 ms
                int tiempoEspera = 500 + random.nextInt(1000);
                Thread.sleep(tiempoEspera);

                /*2. Aquí se podría implementar lógica adicional:
                - Buscar recursos
                - Evitar obstáculos
                - Comunicarse con otras hormigas (feromonas)
                - Regresar al hormiguero

                Por ahora, el movimiento lo gestiona SimuladorColoniasHormigas
                Este run() está preparado para expansiones futuras*/
            }catch (InterruptedException e){
                //Si el hilo es interrumpido, terminanos el bucle
                System.out.println(id + " fue interrumpida");
                activa = false;
                break;
            }
        }

        //Mensaje para cuando la hormiga a terminado su ejecucion
        System.out.println(id + " ha terminado su ejecucion");
    }

    /**
     * Método toString heredado y personalizado para HormigaObrera.
     * <p>
     * Devuelve una representación en cadena específica de la hormiga obrera.
     *
     * @return Una cadena con la información de la hormiga obrera.
     */
    @Override
    public String toString() {
        return "HormigaObrera{" +
                "id='" + id + '\'' +
                ", posicion=" + "(" + posicion.getX() + ", " + posicion.getY() + ")" +
                ", activa=" + activa +
                '}';
    }
}
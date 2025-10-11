/**
 * Enumeración que define los tipos de hormigas en el simulador.
 * <p>
 * Esta enumeración representa los diferentes tipos de hormigas (OBRERA, GUERRERA, REINA)
 * con un símbolo y un nombre asociado para su identificación y visualización en el mapa.
 */
// Enumeracion que define los tipos de hormigas
public enum TipoHormiga {
    // Ceamos las constantes que seran los tipos de hormiga
    OBRERA("O", "Obrera"),
    GUERRERA("G", "Guerra"),
    REINA("R", "Reina");

    // Atributos
    /**
     * Símbolo que representa visualmente el tipo de hormiga en el mapa.
     */
    private final String simbolo; // Simbolo que tendra la hormiga
    /**
     * Nombre que identifica el tipo de hormiga.
     */
    private final String nombre; // Nombre que dira el tipo de hormiga

    /**
     * Constructor de la enumeración TipoHormiga.
     * <p>
     * Inicializa los atributos símbolo y nombre para cada tipo de hormiga.
     *
     * @param simbolo Símbolo asociado al tipo de hormiga.
     * @param nombre  Nombre descriptivo del tipo de hormiga.
     */
    TipoHormiga(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    /**
     * Obtiene el símbolo asociado al tipo de hormiga.
     * <p>
     * Devuelve el carácter que representa visualmente la hormiga.
     *
     * @return El símbolo de la hormiga.
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * Obtiene el nombre asociado al tipo de hormiga.
     * <p>
     * Devuelve el nombre descriptivo de la hormiga.
     *
     * @return El nombre de la hormiga.
     */
    public String getNombre() {
        return nombre;
    }
}
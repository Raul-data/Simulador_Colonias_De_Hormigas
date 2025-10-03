//Enumeracion que define los tipos de hormigas
public enum TipoHormiga {
    //Ceamos las constantes que seran los tipos de hormiga
    OBRERA("O", "Obrera"),
    GUERRERA("G","Guerra"),
    REINA("R", "Reina");

    //Atributos
    private final String simbolo; //Simbolo que tendra la hormiga
    private final String nombre; //Nombre que dira el tipo de hormiga

    TipoHormiga(String simbolo, String nombre) {
        this.simbolo = simbolo;
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public String getNombre() {
        return nombre;
    }


}

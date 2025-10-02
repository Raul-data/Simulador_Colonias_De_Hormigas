//clase que representa el mapa donde se mueven las hormigas
public class Mapa {
    //Creamos los atributos

    //creamos el tamaño del mapa que se mantendra en todo el proceso
    public static final int ANCHO = 10;
    public static final int ALTO = 10;

    //Creamos la posicion del Hormiguero representado con "H"
    private final Posicion hormiguero;

    //Creamos la matriz que representara el mapa de una forma visual
    private final char[][] mapa;

    //Creamos los simbolos que representaran la visualizacion del mapa
    private static final char VACIO = '.'; //Simbolo para representar terreno vacio
    private static final char HORMIGUERO = 'H'; //Simbolo para representar el hormiguero

}

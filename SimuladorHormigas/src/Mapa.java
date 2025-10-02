import java.util.HashMap;

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

    //Creamos el constructor Mapa() que inicializa el mapa
    //0(n^2) -> inicializa la matriz ALTO X ANCHO
    public Mapa(){
        this.mapa = new char[ANCHO][ALTO];
        this.hormiguero = new Posicion(ANCHO / 2, ALTO / 2); // para asignar al centro

        //Iniciamos el mapa vacio
        for(int y = 0; y < ALTO; y++){
            for(int x = 0; x < ANCHO; x++){
                mapa[x][y] = VACIO;
            }
        }

        //Colocamos el hormiguero en el centro
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;
    }

    //METODOS

    //CREamos el metodo que obtiene la posicion del hormiguero
    //0(1) -> va directo
    public Posicion getHormiguero(){
        return hormiguero;
    }

    //verificamos que la posicion esta dentro de los limites del mapa
    //0(1) -> compara directamente
    public boolean dentroLimites(Posicion posicion){
        return (posicion.getX() >= 0 && posicion.getX() < ANCHO && posicion.getY() >= 0 && posicion.getY() < ALTO);
    }

    //preapara el mapa colocando hormiguero mas hormigas activas
    //0(n^2)
    public void prepararMapa(HashMap<String, Hormiga>hormigas){
        //Rellenamos con VACIO
        for(int y = 0; y < ALTO; y++){
            for(int x = 0; x < ANCHO; x++){
                mapa[x][y] = VACIO;
            }
        }

        //Colocamos el hormiguero en el centro
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;

        //Colocamos hormigas en el mapa
        for(Hormiga h : hormigas.values()){
            Posicion pos = h.getPosicion();
            if(dentroLimites(pos)){
                mapa[pos.getY()][pos.getX()] =
            }
        }
    }
}

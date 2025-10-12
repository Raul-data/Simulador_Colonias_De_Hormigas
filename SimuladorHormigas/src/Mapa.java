import java.util.HashMap;
/**
 * Clase que representa el mapa del simulador donde se mueven las hormigas.
 * <p>
 * Esta clase gestiona un mapa de tamaño fijo con un hormiguero en el centro, terrenos vacíos
 * y posiciones para hormigas. Proporciona métodos para inicializar, preparar y mostrar el mapa,
 * verificando límites y sincronizando accesos para hilos.
 */

// clase que representa el mapa donde se mueven las hormigas
public class Mapa {
    // Creamos los atributos
    // creamos el tamaño del mapa que se mantendra en todo el proceso
    /** Ancho fijo del mapa (10 unidades). */
    public static final int ANCHO = 10;
    /** Alto fijo del mapa (10 unidades). */
    public static final int ALTO = 10;

    // Creamos los simbolos que representaran la visualizacion del mapa
    /** Símbolo para representar terreno vacío en el mapa. */
    private static final char VACIO = '.'; // Simbolo para representar terreno vacio
    /** Símbolo para representar el hormiguero en el mapa. */
    private static final char HORMIGUERO = 'H'; // Simbolo para representar el hormiguero

    // Creamos la posicion del Hormiguero representado con "H"
    /** Posición fija del hormiguero en el centro del mapa. */
    private final Posicion hormiguero;

    // Creamos la matriz que representara el mapa de una forma visual
    /** Matriz bidimensional que representa visualmente el mapa con símbolos. */
    private final char[][] mapa;

    /**
     * Constructor de la clase Mapa.
     * <p>
     * Inicializa la matriz del mapa con terrenos vacíos y coloca el hormiguero en el centro.
     */
    // Creamos el constructor Mapa() que inicializa el mapa
    // 0(n^2) -> inicializa la matriz ALTO X ANCHO
    public Mapa() {
        this.mapa = new char[ALTO][ANCHO];
        this.hormiguero = new Posicion(ANCHO / 2, ALTO / 2); // para asignar al centro

        // Iniciamos el mapa vacio
        for (int y = 0; y < ALTO; y++) {
            for (int x = 0; x < ANCHO; x++) {
                mapa[y][x] = VACIO;
            }
        }

        // Colocamos el hormiguero en el centro
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;
    }

    // METODOS

    /**
     * Obtiene la posición del hormiguero.
     * <p>
     * Devuelve la posición central donde se ubica el hormiguero.
     *
     * @return La posición del hormiguero.
     */
    // CREamos el metodo que obtiene la posicion del hormiguero
    // 0(1) -> va directo
    public Posicion getHormiguero() {
        return hormiguero;
    }

    /**
     * Verifica si una posición está dentro de los límites del mapa.
     * <p>
     * Comprueba si las coordenadas de la posición son válidas en el mapa.
     *
     * @param posicion La posición a verificar.
     * @return `true` si está dentro de los límites, `false` en caso contrario.
     */
    // verificamos que la posicion esta dentro de los limites del mapa
    // 0(1) -> compara directamente
    public boolean dentroLimites(Posicion posicion) {
        return (posicion.getX() >= 0 && posicion.getX() < ANCHO && posicion.getY() >= 0 && posicion.getY() < ALTO);
    }

    /**
     * Muestra el mapa en la consola de forma sincronizada.
     * <p>
     * Imprime la matriz del mapa fila por fila con símbolos representativos.
     */
    // Mostrar mapa en consola con synchronized
    // 0(n^2)
    public synchronized void mostrarMapa() {
        System.out.println("\n=== MAPA DE LA COLONIA ===\n");

        // Recorremos el mapa fila por fila
        for (int y = 0; y < ALTO; y++) {
            for (int x = 0; x < ANCHO; x++) {
                System.out.print(mapa[y][x] + " ");
            }
            System.out.println(); // Añadimos una linea nueva al terminar la fila
        }

        System.out.println("\n==========================\n");
    }

    /**
     * Prepara el mapa colocando el hormiguero y las hormigas activas.
     * <p>
     * Reinicia el mapa con terrenos vacíos, coloca el hormiguero y superpone los símbolos
     * de las hormigas en sus posiciones si están dentro de los límites.
     *
     * @param hormigas HashMap con las hormigas activas a colocar en el mapa.
     */
    // preapara el mapa colocando hormiguero mas hormigas activas
    // 0(n^2)
    public void prepararMapa(HashMap<String, Hormiga> hormigas) {
        // Rellenamos con VACIO
        for (int y = 0; y < ALTO; y++) {
            for (int x = 0; x < ANCHO; x++) {
                mapa[y][x] = VACIO;
            }
        }

        // Colocamos el hormiguero en el centro
        mapa[hormiguero.getY()][hormiguero.getX()] = HORMIGUERO;

        // Colocamos hormigas en el mapa
        for (Hormiga hormiga : hormigas.values()) {
            Posicion pos = hormiga.getPosicion();
            if (dentroLimites(pos)) {
                mapa[pos.getY()][pos.getX()] = hormiga.getTipo().getSimbolo().charAt(0);
            }
        }
    }
}
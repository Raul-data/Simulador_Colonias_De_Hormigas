/**
 * Clase que representa una posición (x, y) dentro del mapa del simulador.
 * <p>
 * Esta clase encapsula las coordenadas horizontales (x) y verticales (y) de una posición,
 * proporcionando métodos para acceder a ellas, verificar límites y calcular nuevas posiciones
 * mediante desplazamientos.
 */
// Clase que representa una posicion (x,y) dentro del mapa
public class Posicion {
    // Creamos los atributos: coordenadas de la posición
    /**
     * Coordenada horizontal (columna) de la posición.
     */
    private final int x; // Coordenada horizontal (columna)
    /**
     * Coordenada vertical (fila) de la posición.
     */
    private final int y; // Coorenada vertical (fila)

    /**
     * Constructor que crea una nueva posición con las coordenadas especificadas.
     * <p>
     * Almacena los valores de x e y como atributos finales de la instancia.
     *
     * @param x Coordenada horizontal.
     * @param y Coordenada vertical.
     */
    // Creamos el constructor que nos permite crear nuevas posiciones con las coordenadas, guardándola en los valores "X" e "Y"
    // 0(1) -> Asignamos dos enteros
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Obtiene la coordenada horizontal (x) de la posición.
     * <p>
     * Devuelve el valor de la columna actual.
     *
     * @return La coordenada x.
     */
    // Creamos los Getter para "X" e "Y"
    public int getX() {
        return x;
    }

    /**
     * Obtiene la coordenada vertical (y) de la posición.
     * <p>
     * Devuelve el valor de la fila actual.
     *
     * @return La coordenada y.
     */
    public int getY() {
        return y;
    }

    /**
     * Comprueba si la posición está dentro de los límites especificados del mapa.
     * <p>
     * Verifica que las coordenadas x e y estén dentro del rango [0, maxX) y [0, maxY) respectivamente.
     *
     * @param maxX El ancho máximo del mapa.
     * @param maxY El alto máximo del mapa.
     * @return `true` si la posición está dentro de los límites, `false` en caso contrario.
     */
    // Creamos el metodo para comprobar si la posicion está dentro de los límites del mapa
    // 0(1) -> solo hace comparaciones logicas
    // maxX -> es el ancho del mapa, maxY -> es el alto del mapa
    public boolean dentroLimites(int maxX, int maxY) {
        if ((x >= 0 && x < maxX) && (y >= 0 && y < maxY)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calcula una nueva posición desplazando las coordenadas actuales.
     * <p>
     * Devuelve una nueva instancia de Posicion con las coordenadas sumadas por deltaX y deltaY,
     * sin modificar la posición original.
     *
     * @param deltaX Desplazamiento en la coordenada horizontal.
     * @param deltaY Desplazamiento en la coordenada vertical.
     * @return Una nueva posición con las coordenadas desplazadas.
     */
    // Creamos el metodo para mover la posicion sumando los desplazamientos especificos, IMPORTANTE: devuelve una nueva posicion no modifica la original
    // 0(1) -> simplemente hace las sumas
    public Posicion mover(int deltaX, int deltaY) {
        return new Posicion(this.x + deltaX, this.y + deltaY);
    }
}
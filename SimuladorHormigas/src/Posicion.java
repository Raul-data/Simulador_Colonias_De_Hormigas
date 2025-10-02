//Clase que representa una posicion (x,y) dentro del mapa
public class Posicion {
    //Creamos los atributos: coordenadas de la posición
    private final int x; //Coordenada horizontal (columna)
    private final int y; // Coorenada vertical (fila)

    //Creamos el constructor que nos permite crear nuevas posiciones con las coordenadas, guardándola en los valores "X" e "Y"
    //0(1) -> Asignamos dos enteros
    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Creamos los Getter para "X" e "Y"
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    //Creamos el metodo para comprobar si la posicion está dentro de los límites del mapa
    //0(1) -> solo hace comparaciones logicas
    //maxX -> es el ancho del mapa, maxY -> es el alto del mapa
    public boolean dentroLimites(int maxX, int maxY){
        return (x >= 0 && x < maxX) && (y >= 0 && y < maxY);
    }

    //Creamos el metodo para mover la posicion sumando los desplazamientos especificos, IMPORTANTE: devuelve una nueva posicion no modifica la original
    //0(1) -> simplemente hace las sumas
    public Posicion mover (int deltaX, int deltaY){
        return new Posicion(this.x + deltaX, this.y + deltaY);
    }

}

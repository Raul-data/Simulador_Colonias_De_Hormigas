import java.util.Random;

public abstract class Hormiga extends Thread {
    //Creamos los atributos
    protected final String id; // identificador unico de la hormiga
    protected final TipoHormiga tipo; //Tipo de hormiga (OBRERA,GUERRERA,REINA)
    protected volatile Posicion posicion; //Posicion actual de la hormiga en el mapa
    protected volatile boolean activa; //estado activo/inactivo de la hormiga
    protected final Random random; //generador aleatorio para comportamientos

    //Creamos las direcciones posibles de movimiento
    protected static final int[][] DIRECCIONES = {
            {0,1}, //derecha
            {1,0}, //abajo
            {-1,0}, //arriba
            {0,-1} //izquierda
    };

    //Creamos el constructor Hormiga
    //0(1)
    public Hormiga(String id, TipoHormiga tipo, Posicion posicionInicial){
        this.id = id;
        this.tipo = tipo;
        this.posicion =  posicionInicial;
        this.random = new Random();
        this.activa = true;
    }

    //creamos los Getters
    //0(1)
    public String getIdHormiga(){
        return id;
    }

    public TipoHormiga getTipo(){
        return tipo;
    }

    public Posicion getPosicion(){
        return posicion;
    }

    //creamos el setters solo de la posicion
    //0(1)
    public void setPosicion(Posicion nuevaPosicion){
        this.posicion = nuevaPosicion;
    }

    //verificamos que la hormiga esta activa
    //0(1)
    public boolean isActiva(){
        return activa;
    }

    //DEtener a la hormiga de forma segura
    //0(1)
    public void detener(){
        activa = false;
    }

    //creamos el metodo run para hilos (Por ahora vacio)
    @Override
    public void run(){

    }

}

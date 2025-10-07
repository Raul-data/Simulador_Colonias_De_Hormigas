import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        try{
            //Creamos el mapa
            Mapa mapa = new Mapa();

            //preparamos el mapa
            mapa.prepararMapa(new HashMap<>());

            //mostramos el mapa
            mapa.mostrarMapa();

            //Creamos la simulacion de la colonia
            SimuladorColoniasHormigas simulador  = new SimuladorColoniasHormigas();

            //generar las hormigas obreraras
            simulador.generarHormigaObrera();

        }catch (Exception e){
            System.err.println("Error al preparar Mapa: " + e.getMessage());
        }
    }
}
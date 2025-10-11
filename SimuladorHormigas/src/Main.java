import java.util.HashMap;

/**
 * Clase principal que contiene el punto de entrada del simulador de colonias de hormigas.
 * <p>
 * Esta clase inicia la simulación creando un mapa, preparando las estructuras iniciales,
 * y ejecutando la lógica básica del simulador, incluyendo la generación de hormigas obreras.
 * Maneja excepciones para garantizar una ejecución robusta.
 */
public class Main {
    /**
     * Método principal que inicia la simulación de colonias de hormigas.
     * <p>
     * Crea un mapa, lo prepara con un HashMap vacío, lo muestra, inicializa el simulador,
     * y genera hormigas obreras. Captura excepciones para manejar errores durante la ejecución.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        try {
            // Creamos el mapa
            Mapa mapa = new Mapa();

            // preparamos el mapa
            mapa.prepararMapa(new HashMap<>());

            // mostramos el mapa
            mapa.mostrarMapa();

            // Creamos la simulación de la colonia
            SimuladorColoniasHormigas simulador = new SimuladorColoniasHormigas();

            // generar las hormigas obreraras
            simulador.generarHormigaObrera();

        } catch (Exception e) {
            System.err.println("Error al preparar Mapa: " + e.getMessage());
        }
    }
}
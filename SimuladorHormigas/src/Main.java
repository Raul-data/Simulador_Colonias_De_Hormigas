/**
 * Clase principal que contiene el punto de entrada del simulador de colonias de hormigas.
 * <p>
 * Esta clase inicia la simulación creando el simulador y ejecutándolo.
 * Maneja excepciones para garantizar una ejecución robusta.
 */
public class Main {
    /**
     * Constructor por defecto de la clase Main.
     * <p>
     * Inicializa una instancia de la clase sin parámetros adicionales.
     */
    public Main() {
        // Constructor vacío
    }

    /**
     * Método principal que inicia la simulación de colonias de hormigas.
     * <p>
     * Crea el simulador y ejecuta la simulación completa.
     * Captura excepciones para manejar errores durante la ejecución.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en este caso).
     */
    public static void main(String[] args) {
        try {
            // Banner de bienvenida
            System.out.println("\n-----SIMULADOR DE COLONIA DE HORMIGAS-----\n");

            // Crear el simulador
            SimuladorColoniasHormigas simulador = new SimuladorColoniasHormigas();

            // Ejecutar la simulación completa
            // Esto incluye: generar hormigas, moverlas y mostrar el mapa
            simulador.ejecutar();

            // Mensaje final
            System.out.println("\n-----PROGRAMA FINALIZADO CORRECTAMENTE-----\n");


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
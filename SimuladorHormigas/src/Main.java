import java.util.Scanner;

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
        Scanner scanner =new Scanner(System.in);

        try {
            // Banner de bienvenida
            System.out.println("\n-----SIMULADOR DE COLONIA DE HORMIGAS-----\n");

            // Pregunta 1 ¿Quieres empezar la simulacion?
            System.out.println("¿Quieres iniciar la simulacion?(presiona enter para continuar)");
            scanner.nextLine();

            // Crear el simulador
            SimuladorColoniasHormigas simulador = new SimuladorColoniasHormigas();

            // Ejecutar la simulación completa
            // Esto incluye: generar hormigas, moverlas y mostrar el mapa
            simulador.ejecutar();

            //Pregunta 2 ¿Quieres continuar con mas interaciones?
            boolean continuar = true;
            while (continuar) {
                System.out.println("\n¿Quieres continuar con la simulacion? (S/N)");
                String respuesta = scanner.nextLine().trim().toUpperCase();

                if (respuesta.equals("S") || respuesta.equals("Si") || respuesta.equals("si") || respuesta.equals("SI") || respuesta.equals("")){
                    System.out.println("\nContinuamos con 10 interaciones mas\n");

                    //Continuar 10 iteraciones mas
                    simulador.continuarIteracion(10);

                }else{
                    continuar = false;
                    System.out.println("\n Finalizando simulacion...");
                    simulador.detenerSimulacion();
                }
            }

            // Mensaje final
            System.out.println("\n-----PROGRAMA FINALIZADO CORRECTAMENTE-----\n");


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }finally {
            scanner.close();
        }
    }

    private static void continuarSimulacion(SimuladorColoniasHormigas simulador, int iteracionesExtra){
        try{
            for(int i = 0; i < iteracionesExtra; i++){
                //Esperar 1 segundo entre actualizaccion
                Thread.sleep(1000);

                //aqui tendriamos que meter un metodo publico para actualizar pero por ahora solo mostraremos el mensaje
                System.out.println("Iteracion extra: " + (i + 1) + " de " + iteracionesExtra);
            }

            System.out.println("\nIteracines extras completadas");
        }catch(InterruptedException e){
            System.err.println("Error durante iteraciones extra: " + e.getMessage());
        }
    }
}
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filas = 4;
        int columnas = 7;

        int[][] citas = new int[filas][columnas];
        String[][] dias_semana = new String[filas][columnas];

        crear_calendario(citas, dias_semana);

        System.out.println("\n--- CONFIGURACIÓN ALMAZARA ---");
        System.out.print("Introduce los kilos extra para aumentar la capacidad diaria: ");
        int kilos_extra = scanner.nextInt();

        rellenar_kilos_dia(kilos_extra, citas);

        System.out.println("\n--- DATOS DEL AGRICULTOR ---");

        System.out.print("Introduce los kilos de aceitunas que traes: ");
        int kilos_agricultor = scanner.nextInt();

        System.out.print("Introduce la calidad (suprema, buena, mala, regular): ");
        String calidad = scanner.next();

        float litros = litrosAceite(calidad, kilos_agricultor);

        if (litros == -1) {
            System.out.println("Error: Calidad de aceituna no válida.");
        } else {
            System.out.printf("Tus aceitunas generarán aproximadamente: %.2f litros de aceite.%n", litros);

            int dias_necesarios = dias_para_hacer_aceite(kilos_agricultor, citas, dias_semana);

            System.out.println("\n--- RESULTADO FINAL ---");
            if (dias_necesarios != -1) {
                System.out.println("Se necesitarán " + dias_necesarios + " días de trabajo en la almazara.");
                System.out.println("Calendario de entrega (Días marcados):");
                mostrar_matriz_dias(dias_semana);
            } else {
                System.out.println("NO SE PUEDE COMPLETAR EL PROCESO.");
                System.out.println("No hay suficiente capacidad en el mes para procesar tantos kilos.");
            }
        }

        scanner.close();
    }

    public static void crear_calendario(int citas[][], String dias_semana[][]) {
        Random random = new Random();
        System.out.println("Inicializando matrices...");

        for (int i = 0; i < citas.length; i++) {
            int dia_descanso = random.nextInt(7);
            for (int j = 0; j < citas[0].length; j++) {
                dias_semana[i][j] = "*";
                if (j == dia_descanso) {
                    citas[i][j] = -1;
                } else {
                    citas[i][j] = 0;
                }
            }
        }
    }

    public static void rellenar_kilos_dia(int kilos, int citas[][]) {
        Random random = new Random();
        System.out.println("\nCapacidad diaria de la almazara (kg):");

        // AQUÍ ESTABA EL FALLO: Faltaba imprimir la cabecera
        for (int k = 0; k < 7; k++) {
            System.out.printf("%-6s", dia(k));
        }
        System.out.println(); // Salto de línea después de los nombres

        for (int i = 0; i < citas.length; i++) {
            for (int j = 0; j < citas[i].length; j++) {
                if (citas[i][j] != -1) {
                    citas[i][j] = random.nextInt(1000) + 1 + kilos;
                }
                System.out.printf("%-6d", citas[i][j]);
            }
            System.out.println();
        }
    }

    public static float litrosAceite(String calidad, int kilos) {
        calidad = calidad.toLowerCase();
        float rendimiento = 0;

        switch (calidad) {
            case "suprema": rendimiento = 0.28f; break;
            case "buena":   rendimiento = 0.22f; break;
            case "regular": rendimiento = 0.15f; break;
            case "mala":    rendimiento = 0.08f; break;
            default: return -1;
        }
        return kilos * rendimiento;
    }

    public static int dias_para_hacer_aceite(int numKilos, int citas[][], String dias_semana[][]) {
        int dias_totales = 0;
        int kilos_restantes = numKilos;

        for (int i = 0; i < citas.length; i++) {
            for (int j = 0; j < citas[0].length; j++) {

                if (kilos_restantes <= 0) {
                    return dias_totales;
                }

                if (citas[i][j] == -1) {
                    continue;
                }

                String nombreDia = dia(j);

                if (kilos_restantes > citas[i][j]) {
                    kilos_restantes -= citas[i][j];
                    citas[i][j] = 0;
                    dias_semana[i][j] = nombreDia;
                    dias_totales++;
                } else {
                    citas[i][j] -= kilos_restantes;
                    kilos_restantes = 0;
                    dias_semana[i][j] = nombreDia;
                    dias_totales++;
                    return dias_totales;
                }
            }
        }

        if (kilos_restantes > 0) {
            return -1;
        }

        return dias_totales;
    }

    public static String dia(int num) {
        String[] nombres = {"Lunes", "Martes", "Mierc", "Jueves", "Viern", "Sabad", "Domin"};
        if (num >= 0 && num < 7) {
            return nombres[num];
        }
        return "Error";
    }

    public static void mostrar_matriz_dias(String[][] dias_semana) {
        for (int k = 0; k < 7; k++) {
            System.out.printf("%-10s", dia(k));
        }
        System.out.println();

        for (int i = 0; i < dias_semana.length; i++) {
            for (int j = 0; j < dias_semana[0].length; j++) {
                System.out.printf("%-10s", dias_semana[i][j]);
            }
            System.out.println();
        }
    }
}
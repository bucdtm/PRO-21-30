import java.util.Scanner;
import java.util.Random;

public class OnePlus {

    static Scanner sc = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        String respuesta = "S";
        String semilla = "ONEPLUS_";

        do {
            String[][] matriz = new String[5][5];
            generar_matriz(matriz);

            int nCupones = 0;
            boolean entradaValida = false;
            while (!entradaValida) {
                System.out.println("Introduce el número de cupones que quieres generar (Entre 1 y 25)");
                try {
                    String input = sc.nextLine();
                    nCupones = Integer.parseInt(input);
                    if (nCupones >= 1 && nCupones <= 25) {
                        entradaValida = true;
                    } else {
                        System.out.println("Por favor, un número entre 1 y 25.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduce un número válido.");
                }
            }

            generar_cupones(semilla, nCupones, matriz);
            imprimir_matriz(matriz);

            int casilla = -1;
            entradaValida = false;
            while (!entradaValida) {
                System.out.println("Indica el número con el que quieres participar (Entre 0 y 24):");
                try {
                    String input = sc.nextLine();
                    casilla = Integer.parseInt(input);
                    if (casilla >= 0 && casilla <= 24) {
                        entradaValida = true;
                    } else {
                        System.out.println("El número debe estar entre 0 y 24.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Introduce un número entero.");
                }
            }

            String resultado = seleccionar_regalo(casilla, matriz);
            if (resultado.equals("No has obtenido premio")) {
                System.out.println(resultado);
            } else {
                System.out.println("Has ganado un: " + resultado);
            }

            System.out.println("\n---------------------------------");
            System.out.println("Desea volver a jugar? (S/N)");
            respuesta = sc.nextLine();

        } while (respuesta.equalsIgnoreCase("S"));

        System.out.println("Gracias por jugar.");
    }

    public static void generar_matriz(String matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = "*";
            }
        }
    }

    public static void generar_cupones(String semilla, int ncupones, String[][] matriz) {
        boolean[] idUsado = new boolean[ncupones + 1];
        int cuponesGenerados = 0;

        while (cuponesGenerados < ncupones) {
            int idAleatorio = rnd.nextInt(ncupones) + 1;

            if (!idUsado[idAleatorio]) {
                boolean posEncontrada = false;

                while (!posEncontrada) {
                    int posAleatoria = rnd.nextInt(25);
                    int fila = posAleatoria / 5;
                    int col = posAleatoria % 5;

                    if (matriz[fila][col].equals("*")) {
                        matriz[fila][col] = semilla + idAleatorio;
                        idUsado[idAleatorio] = true;
                        posEncontrada = true;
                        cuponesGenerados++;
                    }
                }
            }
        }
    }

    public static String seleccionar_regalo(int numero, String matriz[][]) {
        int fila = numero / 5;
        int col = numero % 5;

        String contenido = matriz[fila][col];

        if (contenido.equals("*")) {
            return "No has obtenido premio";
        } else {
            return contenido;
        }
    }

    public static void imprimir_matriz(String[][] matriz) {
        System.out.println();
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j].equals("*")) {
                    System.out.printf("%-20s", "*");
                } else {
                    System.out.printf("Cupon %-14s", matriz[i][j]);
                }
            }
            System.out.println("\n");
        }
    }
}
import java.util.Scanner;

public class PrimerEjercicio {

    public static void main(String[] args) {
        char b = 'b', c = 'c';
        int longitud_maxima = 6;
        char[][] tablero1 = new char[longitud_maxima][longitud_maxima];
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            opcion = menu(sc);

            switch (opcion) {
                case 1 -> generar_bomba(b, c, tablero1, sc);
                case 2 -> System.out.println("Nueva partida empezada: ");
                case 3 -> System.out.println("Programa finalizado");
                default -> System.out.println("Opción no permitida, vuelve a introducir un valor: ");
            }

            if (opcion != 3 && opcion != 1) {
                System.out.println("\nPresiona Enter para continuar...");
                sc.nextLine();
            }

        } while (opcion != 3);

        sc.close();
    }

    static void inicializar_tablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = '*';
            }
        }
    }

    public static int menu(Scanner sc) {
        System.out.println("Programa que muestra un menú con diferentes juegos:\n");
        System.out.println("[1] Desactivar bomba");
        System.out.println("[2] Nueva partida");
        System.out.println("[3] Salir");
        System.out.print("\nIntroduce la opción deseada: ");

        int opcion = -1;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Inténtalo de nuevo con un número válido.");
        }
        System.out.println();
        return opcion;
    }

    public static void generar_bomba(char b, char c, char[][] tablero, Scanner sc) {
        // Coordenadas aleatorias entre 1 y 4 (evitando bordes)
        int fila_aleatoria = (int) (Math.random() * 4) + 1;
        int columna_aleatoria = (int) (Math.random() * 4) + 1;
        int longitud_matriz = tablero.length;

        inicializar_tablero(tablero);

        // Recorrer el tablero completo desde (0,0)
        for (int i = 0; i < longitud_matriz; i++) {
            for (int j = 0; j < longitud_matriz; j++) {
                if (i == fila_aleatoria && j == columna_aleatoria) {
                    tablero[i][j] = b;
                } else if (i == 0 || i == longitud_matriz - 1 || j == 0 || j == longitud_matriz - 1) {
                    tablero[i][j] = '*';
                } else {
                    tablero[i][j] = c;
                }
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }

        desactivar_bomba(tablero, sc);
    }

    public static boolean desactivar_bomba(char[][] tablero, Scanner sc) {
        int intentos = 8;
        boolean finalizado = false;
        boolean victoria = false;

        while (!finalizado && intentos > 0) {
            System.out.println("\nAdivina las coordenadas (0 a " + (tablero.length - 1) + "):");
            
            int x = leerEntero(sc, "Fila (x): ", 0, tablero.length - 1);
            int y = leerEntero(sc, "Columna (y): ", 0, tablero[0].length - 1);

            char casilla = tablero[x][y];

            if (casilla == 'b') {
                System.out.println("¡Has acertado! Bomba desactivada.");
                victoria = true;
                finalizado = true;
            } else {
                intentos--;
                if (casilla == 'c') {
                    System.out.println("Casi aciertas.");
                } else {
                    System.out.println("Has fallado.");
                }

                if (intentos == 0) {
                    System.out.println("¡Has perdido! Te quedaste sin intentos.");
                    finalizado = true;
                } else {
                    System.out.println("Te quedan " + intentos + " intentos.");
                }
            }
        }
        return victoria;
    }

    private static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Por favor, introduce un número entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entero.");
            }
        }
    }
}

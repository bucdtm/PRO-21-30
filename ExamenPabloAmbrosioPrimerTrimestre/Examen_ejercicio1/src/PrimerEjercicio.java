import java.util.*;

public class PrimerEjercicio {

    public static void main(String[] args) {

        char b = 'b', c = 'c', hueco = '*';
        int longitud_maxima = 6;
        char[][] tablero1 = new char[longitud_maxima][longitud_maxima];

        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            opcion = menu(sc);

            switch (opcion) {
                case 1 -> generar_bomba(b,c,tablero1);
                case 2 -> System.out.println("Nueva partida empezada: ");
                case 3 -> System.out.println("Programa finalizado");
                default -> System.out.println("Opción no permitida, vuelve a introducir un valor: ");
            }

            if (opcion != 3 || opcion != 1) {
                System.out.println("\nPresiona Enter");
                sc.nextLine();
            }

        } while (opcion != 3);

        sc.close();
    }


    static void inicializar_tablero(char[][] tablero) {

        int longitud_matriz = 6;

        for (int i = 0; i < longitud_matriz; i++) {
            for (int j = 0; j < longitud_matriz; j++) {
                tablero[i][j] = '*';
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    public static int menu(Scanner sc) {

        System.out.println("Programa que muestra un menú con diferentes juegos: ");
        System.out.println();
        System.out.println("[1] Desactivar bomba");
        System.out.println("[2] Nueva partida");
        System.out.println("[3] Salir");
        System.out.print("\nIntroduce la opción deseada: ");

        int opcion = -1;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Intentalo de nuevo con un número válido.");
        }
        System.out.println();
        return opcion;
    }

    public static void generar_bomba(char b, char c, char[][] tablero) {

        int numero_aleatorio_uno = (int) Math.random()*(5-1)+1;
        int numero_aleatorio_dos = (int) Math.random()*(5-1)+1;
        int fila_aleatoria = numero_aleatorio_uno;
        int columna_aleatoria = numero_aleatorio_dos;
        int longitud_matriz = 6;
        int posicion_uno = 0, posicion_dos = 0;
        Scanner sc = new Scanner(System.in);

        inicializar_tablero(tablero); // tablero sin bombas

        System.out.println();

            for (int i = fila_aleatoria; i < longitud_matriz; i++) {
                for (int j = columna_aleatoria; j < longitud_matriz; j++) {
                    if (i == fila_aleatoria && j == columna_aleatoria) {
                        tablero[i][j] = b;
                    } else if (i == 0 || i == longitud_matriz - 1 || j == 0 || j == longitud_matriz - 1) {
                        tablero[i][j] = '*';
                    } else {
                        tablero[i][j] = c;
                    }
                    System.out.print(tablero[i][j]);
                }
                System.out.println();
            }

        desactivar_bomba(posicion_uno, posicion_dos, tablero);

    }

    public static boolean desactivar_bomba(int posicion_uno,int posicion_dos, char[][] tablero) {
        int intentos = 8;
        boolean validar = false;
        Scanner sc = new Scanner(System.in);

        while (!validar) {
        System.out.println("Ahora adivina donde esta la bomba: (formato coordenadas (x,y))");
        System.out.println("x: ");
        posicion_uno = sc.nextInt();
        System.out.println("y: ");
        posicion_dos = sc.nextInt();

            if (tablero[posicion_uno][posicion_dos] == '*') {
                intentos--;
                if (intentos <= 0){
                    System.out.println("Has perdido!");
                    validar = true;
                }
                System.out.println("Has fallado, te quedan " + intentos + " intentos.");
                continue;
            } else if (tablero[posicion_uno][posicion_dos] == 'c') {
                intentos--;
                if (intentos <= 0){
                    System.out.println("Has perdido!");
                    validar = true;
                }
                System.out.println("Casi aciertas, te quedan " + intentos + " intentos.");
                continue;
            } else if (tablero[posicion_uno][posicion_dos] == 'b') {
                System.out.println("Has acertado!");
                validar = true;
            }
        }
        return validar;
    }
}

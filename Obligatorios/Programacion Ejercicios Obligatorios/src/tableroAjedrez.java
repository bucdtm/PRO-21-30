import java.util.Scanner;

public class tableroAjedrez {

    private static final char REINA_B = '♕';
    private static final char CUADRO_BLANCO = '⬜';
    private static final char CUADRO_NEGRO = '⬛';
    public static final int FILAS = 8;
    public static final int COLUMNAS = 8;

    public static void main(String[] args) {
        String[][] tablero = new String[FILAS][COLUMNAS];
        Scanner scanner = new Scanner(System.in);

        inicializarTablero(tablero);
        mostrarTablero(tablero);

        int[] posDama = solicitarPosicionInicial(scanner);
        tablero[posDama[0]][posDama[1]] = String.valueOf(REINA_B);
        mostrarTablero(tablero);

        while (true) {
            System.out.println("Mover Dama (Origen Destino, ej: D1 H5) o 'SALIR':");
            String entrada = scanner.nextLine().toUpperCase().trim();

            if (entrada.equalsIgnoreCase("SALIR")) break;

            try {
                procesarMovimiento(tablero, entrada);
                mostrarTablero(tablero);
            } catch (Exception e) {
                System.out.println("Error de formato. Usa: LetraNumero LetraNumero");
            }
        }
        scanner.close();
    }

    static void inicializarTablero(String[][] tablero) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                tablero[i][j] = ((i + j) % 2 != 0) ? String.valueOf(CUADRO_BLANCO) : String.valueOf(CUADRO_NEGRO);
            }
        }
    }

    static int[] solicitarPosicionInicial(Scanner scanner) {
        while (true) {
            System.out.print("Posición inicial de la Dama (ej: D1): ");
            String entrada = scanner.nextLine().toUpperCase().trim();
            if (entrada.length() == 2) {
                int col = entrada.charAt(0) - 'A';
                int fila = 8 - Character.getNumericValue(entrada.charAt(1));
                if (fila >= 0 && fila < FILAS && col >= 0 && col < COLUMNAS) return new int[]{fila, col};
            }
            System.out.println("Coordenada no válida.");
        }
    }

    static void procesarMovimiento(String[][] tablero, String entrada) {
        String[] partes = entrada.split("\\s+");
        if (partes.length != 2) return;

        int c1 = partes[0].charAt(0) - 'A';
        int f1 = 8 - Character.getNumericValue(partes[0].charAt(1));
        int c2 = partes[1].charAt(0) - 'A';
        int f2 = 8 - Character.getNumericValue(partes[1].charAt(1));

        if (f1 < 0 || f1 >= FILAS || c1 < 0 || c1 >= COLUMNAS || f2 < 0 || f2 >= FILAS || c2 < 0 || c2 >= COLUMNAS) {
            System.out.println("Fuera de los límites del tablero.");
            return;
        }

        if (!tablero[f1][c1].equals(String.valueOf(REINA_B))) {
            System.out.println("No hay una Dama en " + partes[0]);
            return;
        }

        int diffFila = Math.abs(f2 - f1);
        int diffCol = Math.abs(c2 - c1);

        boolean esMovimientoValido = (f1 == f2) || (c1 == c2) || (diffFila == diffCol);

        if (esMovimientoValido) {
            tablero[f2][c2] = tablero[f1][c1];
            tablero[f1][c1] = ((f1 + c1) % 2 != 0) ? String.valueOf(CUADRO_BLANCO) : String.valueOf(CUADRO_NEGRO);
        } else {
            System.out.println("Movimiento ilegal para la Dama.");
        }
    }

    static void mostrarTablero(String[][] tablero) {
        System.out.println("\n   A B C D E F G H");
        for (int i = 0; i < FILAS; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < COLUMNAS; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println(" " + (8 - i));
        }
        System.out.println("   A B C D E F G H\n");
    }
}
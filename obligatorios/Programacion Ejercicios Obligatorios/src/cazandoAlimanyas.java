import java.util.Random;
import java.util.Scanner;

public class cazandoAlimanyas {
    public static void main(String[] args) {
        int tamanyoMatriz = 4;
        char[][] matrizDieciseis = new char[tamanyoMatriz][tamanyoMatriz];
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            opcion = menu(sc);

            switch (opcion) {
                case 1 -> generarAlimanya(tipoAlimanya(),matrizDieciseis);
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
    public static int tipoAlimanya() {
        Random random = new Random();
        int tipoAlimanya = random.nextInt(0, 5);
        switch (tipoAlimanya) {
            case 0:             // En línea
                return 0;
            case 1:             // En columna
                return 1;
            case 2:             // En diagonal de izquierda a derecha
                return 2;
            case 3:             // En diagonal de derecha a izquierda
                return 3;
            default:
                return 0;
        }
    }
    public static void generarAlimanya(int forma, char [][] tablero){
        Random random = new Random();
        int filaColumnaAleatoria = random.nextInt(0, 4);
        int posicion = 0;
        boolean validar = false;
        Scanner sc = new Scanner(System.in);
        /*
        Introducción programa
         */

        System.out.println("Bienvenido al juego de cazando alimañas!");
        System.out.println();
        System.out.println("Revisa la tabla y prueba suerte para cazar la alimaña!");

        /*
        Inicializacion de la matriz para que no quede con valores nulos
         */
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '*';
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        /*
          Creacion de la forma de la matriz en funcion del parametro aleatorio recogido de ## tipoAlimanya()
         */
        switch (forma) {
            case 0:             // En línea
                for (int i = 0; i < tablero.length; i++) {
                    tablero[i][filaColumnaAleatoria] = '@';
                }
                break;
            case 1:             // En columna
                for (int i = 0; i < tablero.length; i++) {
                    tablero[filaColumnaAleatoria][i] = '@';
                }
                break;
            case 2:             // En diagonal de izquierda a derecha
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        if (i == j) {
                            tablero[i][j] = '@';
                        }
                    }
                }
                break;
            case 3:             // En diagonal de derecha a izquierda
                for (int i = 0; i < tablero.length; i++) {
                    for (int j = 0; j < tablero.length; j++) {
                        if (i + j == tablero.length - 1) {
                            tablero[i][j] = '@';
                        }
                    }
                }
                break;
        }
        /*
        Impresion de la matriz a nivel desarrollador
         */

//        for (int i = 0; i < tablero.length; i++) {
//            for (int j = 0; j < tablero.length; j++) {
//                System.out.print(tablero[i][j] + " ");
//            }
//            System.out.println();
//        }

        /*
        Llamada de funcion booleana disparar para confirmar que se da en el objetivo
         */

    disparar(tablero);

    }
    public static void disparar(char[][] tablero) {
        Scanner sc = new Scanner(System.in);
        int intentos = 8;
        int alimanyasPorCazar = 4;
        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            int posicion = -1;
            boolean entradaValida = false;

            System.out.println("\n------------------------------------------------");
            System.out.println("Intentos: " + intentos + " | Alimañas restantes: " + alimanyasPorCazar);
            System.out.print("¿Dónde quieres disparar? (0-15): ");

            while (!entradaValida) {
                try {
                    posicion = Integer.parseInt(sc.nextLine());
                    if (posicion >= 0 && posicion <= 15) {
                        entradaValida = true;
                    } else {
                        System.out.print("Error: Introduce un número del 0 al 15: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Error: Eso no es un número válido. Prueba otra vez: ");
                }
            }

            // Traducir posición (0-15) a Fila y Columna
            int fila = posicion / 4;
            int columna = posicion % 4;

            char casilla = tablero[fila][columna];

            if (casilla == 'X' || casilla == 'O') {
                System.out.println("¡Ya habías disparado en esta posición! No pierdes intento.");

            } else if (casilla == '@') {
                alimanyasPorCazar--;
                System.out.println(">>> ¡BOOM! Has acertado. <<<");

                if (alimanyasPorCazar == 0) {
                    System.out.println("\n¡ENHORABUENA! Has cazado a todas las alimañas. ¡HAS GANADO!");
                    juegoTerminado = true; // Fin del juego
                }

            } else {
                // Fallo (casilla == '*')
                intentos--;
                tablero[fila][columna] = 'O'; // Marcamos el fallo con O
                System.out.println(">>> Agua... has fallado. <<<");

                if (intentos == 0) {
                    System.out.println("\nTe has quedado sin intentos. ¡HAS PERDIDO!");
                    juegoTerminado = true; // Fin del juego
                }
            }
        }
    }
/*
              _.--""`-..
            ,'          `.
          ,'          __  `.
         /|          " __   \
        , |           / |.   .
        |,'          !_.'|   |
      ,'             '   |   |
     /              |`--'|   |
    |                `---'   |
     .   ,                   |                       ,".
      ._     '           _'  |                    , ' \ `
  `.. `.`-...___,...---""    |       __,.        ,`"   L,|
  |, `- .`._        _,-,.'   .  __.-'-. /        .   ,    \
-:..     `. `-..--_.,.<       `"      / `.        `-/ |   .
  `,         """"'     `.              ,'         |   |  ',,
    `.      '            '            /          '    |'. |/
      `.   |              \       _,-'           |       ''
        `._'               \   '"\                .      |
           |                '     \                `._  ,'
           |                 '     \                 .'|
           |                 .      \                | |
           |                 |       L              ,' |
           `                 |       |             /   '
            \                |       |           ,'   /
          ,' \               |  _.._ ,-..___,..-'    ,'
         /     .             .      `!             ,j'
        /       `.          /        .           .'/
       .          `.       /         |        _.'.'
        `.          7`'---'          |------"'_.'
       _,.`,_     _'                ,''-----"'
   _,-_    '       `.     .'      ,\
   -" /`.         _,'     | _  _  _.|
    ""--'---"""""'        `' '! |! /
                            `" " -' mh
 */

    public static int menu(Scanner sc) {

        System.out.println("Programa para cazar alimañas dentro de una matriz de 4x4");
        System.out.println();
        System.out.println("[1] Cazar Alimaña");
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
}





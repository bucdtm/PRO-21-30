import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean validar = false;

        while(!validar) {
            String palabra = "palabra";
            System.out.println("Ingrese su palabra/frase: ");
            palabra = sc.nextLine();

            if (palabra.length() < 3) {
                System.out.println("Palabra invalida, ingrese una palabra con mas de 3 letras e impar");
                continue;
            } else if (palabra.length() % 2 == 0) {
                System.out.println("Palabra tiene que ser impar");
            } else  {
                char[][] matriz = new char[palabra.length()][palabra.length()];
                int altura_por_ancho = (int) Math.pow(palabra.length(), 2);

                for (int i = 0; i < palabra.length(); i++) {
                    for (int j = 0; j < palabra.length(); j++) {
                        int contador_extra = 0;
                        matriz[i = palabra.length() / 2 - contador_extra][j] = palabra.charAt(palabra.length() / 2);


                        System.out.println(matriz[i][j]);
                    }
                    System.out.println();
                }

                validar = true;
            }
        }



    }
}
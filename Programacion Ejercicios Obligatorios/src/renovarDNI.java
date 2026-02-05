import java.util.ArrayList;
import java.util.Scanner;

public class renovarDNI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean validar = false;
        String dni = null;
        String[] posiblesDNI = new String[100];

        while (!validar) {
            System.out.println("Introduzca su DNI con un maximo de 2 errores, ejemplo: 12X45X78Z");
            dni = sc.nextLine();
            if (dni.length() == 9) {
                validar = true;
            } else {
                System.out.println("Introduza un DNI con un numero de letras iguales a 8 + 1 letra");
                continue;
            }
        }
        System.out.println("Introduzca el caracter que hace de patron en su dni");
        String patron = sc.nextLine();

        int cantidad = repararDNI(dni, patron, posiblesDNI);

        System.out.println("--- RESULTADOS ENCONTRADOS ---");
        System.out.println("Se han encontrado " + cantidad + " coincidencias:");
        for(int i = 0; i < cantidad; i++){
            System.out.println(posiblesDNI[i]);
        }
    }

    public static char calculaDNI(int dni){
        char[] letrasDNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        return letrasDNI[dni%23];
    }

    public static int repararDNI(String DNI, String patron, String posibles_dni[]){
        char letraOriginal = DNI.toUpperCase().charAt(8);

        String parteNumerica = DNI.substring(0, 8);

        int encontrados = 0;

        int numErrores = 0;
        for (int i = 0; i < parteNumerica.length(); i++) {
            if (String.valueOf(parteNumerica.charAt(i)).equals(patron)) {
                numErrores++;
            }
        }

        if (numErrores == 1) {
            for (int i = 0; i <= 9; i++) {
                String intentoString = parteNumerica.replaceFirst(patron, String.valueOf(i));
                int intentoNum = Integer.parseInt(intentoString);

                if (calculaDNI(intentoNum) == letraOriginal) {
                    posibles_dni[encontrados] = intentoString + letraOriginal;
                    encontrados++;
                }
            }
        }
        else if (numErrores == 2) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    String intentoString = parteNumerica.replaceFirst(patron, String.valueOf(i));
                    intentoString = intentoString.replaceFirst(patron, String.valueOf(j));

                    int intentoNum = Integer.parseInt(intentoString);

                    if (calculaDNI(intentoNum) == letraOriginal) {
                        posibles_dni[encontrados] = intentoString + letraOriginal;
                        encontrados++;
                    }
                }
            }
        }

        return encontrados;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class DdRecuperarElementoIndiceEspecificadoArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores: " + coloreslista);

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el elemento que desea recuperar");
        int numero = sc.nextInt();

        System.out.println(coloreslista.get(numero));


    }
}

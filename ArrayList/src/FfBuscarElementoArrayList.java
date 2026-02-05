import java.util.ArrayList;
import java.util.Scanner;

public class FfBuscarElementoArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores: " + coloreslista);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < coloreslista.toArray().length; i++) {
            System.out.println("Introduce un nombre de color y el Contains lo buscara");
            String color = sc.nextLine();
            color = color.trim();

            if(coloreslista.contains(color)){
                System.out.println("Verdadero");
            } else {
                System.out.println("Falso");
            }

        }

    }
}

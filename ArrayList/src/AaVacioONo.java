import java.util.*;

public class AaVacioONo {
    public static void main(String[] args) {

        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};


        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores lista: " + coloreslista);

        if (coloreslista == null) {
            System.out.println("No colores encontrados");
        } else {
            System.out.println("Colores encontrados: " + coloreslista);
        }

    }
}

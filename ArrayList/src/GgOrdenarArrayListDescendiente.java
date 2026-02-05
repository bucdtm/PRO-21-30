import java.util.ArrayList;
import java.util.Collections;

public class GgOrdenarArrayListDescendiente {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        Collections.sort(coloreslista);

        System.out.println("Orden Ascendiente  \n");
        System.out.println("Colores: " + coloreslista);

        Collections.reverse(coloreslista);

        System.out.println("Orden Descendiente  \n");
        System.out.println("Colores: " + coloreslista);

    }
}

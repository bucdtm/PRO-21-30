import java.util.ArrayList;
import java.util.Collections;

public class LlCompararDosArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();
        ArrayList coloreslista2 = new ArrayList();


        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
            coloreslista2.add(colores[i]);
        }

        Collections.shuffle(coloreslista);
        Collections.sort(coloreslista2);

        for (int i = 0; i < coloreslista2.size(); i++) {
            if (coloreslista2.get(i).equals(coloreslista.get(i))) {
                System.out.println("Color Lista 2: "+coloreslista2.get(i));
                System.out.println("Color Lista 1: "+coloreslista.get(i));
                System.out.println("True");
            } else  {
                System.out.println("Color Lista 2: "+coloreslista2.get(i));
                System.out.println("Color Lista 1: "+coloreslista.get(i));
                System.out.println("False");
            }
        }

    }
}

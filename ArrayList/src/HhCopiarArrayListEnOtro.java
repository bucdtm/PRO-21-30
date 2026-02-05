import java.util.ArrayList;

public class HhCopiarArrayListEnOtro {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores 1: " + coloreslista);

        ArrayList coloreslista2 = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista2.add(coloreslista.get(i));
        }
        System.out.println("Colores 2: " + coloreslista2);

    }
}

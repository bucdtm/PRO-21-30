import java.util.ArrayList;

public class BbBorrarArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println(coloreslista);

        while (!coloreslista.isEmpty()) {
            coloreslista.remove(0);
        }
        System.out.println();
        System.out.println(coloreslista);
    }
}

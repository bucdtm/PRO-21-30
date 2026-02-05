import java.util.ArrayList;

public class CcInsertarNumeroPrimeraPosicionArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores lista: " + coloreslista);

        coloreslista.add(0, "Morado");

        System.out.println("Colores lista: " + coloreslista);
    }
}

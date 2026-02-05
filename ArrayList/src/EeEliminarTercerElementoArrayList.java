import java.util.ArrayList;

public class EeEliminarTercerElementoArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        System.out.println("Colores: " + coloreslista);

        coloreslista.remove(2);

        System.out.println("Colores: " + coloreslista);
    }
}

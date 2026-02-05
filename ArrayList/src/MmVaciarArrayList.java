import java.util.ArrayList;

public class MmVaciarArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        while(!coloreslista.isEmpty()){
            System.out.println("Color: "+coloreslista);
            coloreslista.remove(0);
        }
        System.out.println("Color: " + coloreslista);

    }
}

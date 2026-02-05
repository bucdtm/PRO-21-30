import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KkExtraerPorcionArrayList {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo", "Verde", "Naranja", "Violeta", "Blanco", "Negro", "Rosa", "Marrón"};
        Random rand = new Random();

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        int NumeroAleatorioColores = rand.nextInt(0,11);

        System.out.println(NumeroAleatorioColores);

        for (int i = 0; i < NumeroAleatorioColores; i++) {
            Collections.shuffle(coloreslista);

            System.out.println(coloreslista.get(i));

        }

    }
}

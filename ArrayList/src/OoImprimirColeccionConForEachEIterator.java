import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class OoImprimirColeccionConForEachEIterator {
    public static void main(String[] args) {
        String[] colores = {"Rojo", "Azul", "Amarillo"};

        ArrayList coloreslista = new ArrayList();

        for (int i = 0; i < colores.length; i++) {
            coloreslista.add(colores[i]);
        }

        int n = 1;

        System.out.println("Colores con For:Each: \n");

        for(Object color : coloreslista){
            System.out.println("Color "+n+" : "+color);
            n++;
        }

        System.out.println("Colores con Iterator: \n");

        Iterator it = coloreslista.iterator();

        n = 1;

        while(it.hasNext()){
            System.out.println("Color "+n+" : "+it.next());
            n++;
        }

    }
}

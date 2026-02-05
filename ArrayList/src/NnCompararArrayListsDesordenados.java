import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NnCompararArrayListsDesordenados {
    public static void main(String[] args) {
        List<String> arrayUno = new ArrayList<>(List.of("Alfonso", "Jose", "Sara", "Raul"));
        List<String> arrayDos = new  ArrayList<>(List.of("Jose", "Sara", "Raul", "Alfonso"));


        while(!arrayUno.isEmpty() && !arrayDos.isEmpty()) {
            int i = 0;

            if (arrayUno.get(i).equals(arrayDos.get(i))) {
                System.out.println("El nombre " + arrayUno.get(i) + " es igual a " + arrayDos.get(i));
                arrayUno.remove(i);
                arrayDos.remove(i);
            } else {
                arrayUno.set(i, arrayDos.get(i));
            }

            i++;
        }
    }
}

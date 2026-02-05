import java.util.ArrayList;
import java.util.Scanner;

public class QqActualizarElementosArrayList {
    public static void main(String[] args) {
        ArrayList<String> nombres = new ArrayList<String>();
        int i = 1;
        Scanner sc = new Scanner(System.in);

        nombres.add("Juan");
        nombres.add("Pedro");
        nombres.add("Maria");

        for(String nombres1 : nombres){
            System.out.println("Nombre ("+i+") :   "+ nombres1);
            i++;
        }
        int posicion = 0;
        String valor = " ";

        System.out.println("Indica que posicion quieres modificar: ");
        posicion = sc.nextInt();
        if (posicion == 1){
            posicion = posicion - 1;
        } else if (posicion == 2){
            posicion = posicion - 1;
        } else if (posicion == 3){
            posicion = posicion - 1;
        }
        System.out.println("Indica el nuevo valor: ");
        valor = sc.next();

        nombres.set(posicion, valor);

        i = 1;

        for(String nombres2 : nombres){
            System.out.println("Nombre ("+i+") :   "+ nombres2);
            i++;
        }
    }
}

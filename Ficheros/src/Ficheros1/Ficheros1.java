package Ficheros1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ficheros1 {
    static void main() {
        File archivo1 = new File("archivo1.txt");

        try (Scanner lector = new Scanner(archivo1)){
            while(lector.hasNextLine()){
                String info = lector.nextLine();
                info = info.replaceAll("\\s", "");
                System.out.println(info);
            }
        } catch (FileNotFoundException e){
            System.out.println("No existe o ha habido un error");
            e.printStackTrace();
        }
    }
}

import java.io.*;

public class FicherosPrueba1 {
    public static void main(String[] args) {
        File fichero1 = new File("Contrasenyas.txt");
        try {
            PrintStream escribirFichero = new PrintStream(fichero1);
            escribirFichero.println("Hola Mundo");
            escribirFichero.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

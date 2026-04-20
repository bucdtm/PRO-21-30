package Ficheros3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ficheros3 {
    public static void main(String[] args) {
        try (BufferedReader lector = new BufferedReader(new FileReader("archivo_gigante.txt"))) {
            lector.lines()
                    .filter(line -> line.contains("ERROR"))
                    .limit(10)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

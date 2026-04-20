package Ficheros2;

import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

public class Ficheros2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero:");
        String ruta = scanner.nextLine().trim();
        System.out.println("Introduce el texto a escribir en el fichero:");
        String inputText = scanner.nextLine();

        File archivo = new File(ruta.startsWith("/") ? ruta.substring(1) : ruta);
        if (archivo.getParentFile() != null && !archivo.getParentFile().exists()) {
            archivo.getParentFile().mkdirs();
        }

        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo))) {
            escribir.write(inputText);
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
            return;
        }

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String adjustedText = "";
            String linea;
            while ((linea = lector.readLine()) != null) {
                StringBuilder lineaTransformada = new StringBuilder();
                for (char c : linea.toCharArray()) {
                    if (Character.isAlphabetic(c)) {
                        lineaTransformada.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
                    } else {
                        lineaTransformada.append(c);
                    }
                }
                adjustedText += lineaTransformada.toString() + "\n";
            }
            System.out.println("Texto transformado:");
            System.out.print(adjustedText);
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}

package Ficheros6;

import Ficheros4.Libro;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Ficheros6 {
    static final String ARCHIVO = "alumnos.csv";
    static void main() {
        List<Alumno> Alumnos = alumnosParseados(ARCHIVO);
    }
    static List<Alumno> alumnosParseados(String archivo){
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            return lector.lines()
                    .map(linea -> {
                        String[] partes = linea.split(";");

                        int[] notas = new int[partes.length-3];
                        for (int i = 0; i < notas.length; i++) {
                            notas[i] = Integer.parseInt(partes[i+3]);
                        }

//                        if (partes.length != 3) throw new IllegalArgumentException("Formato inválido: " + linea);
                        return new Alumno(partes[0], partes[1], Integer.parseInt(partes[2]),notas);
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    static void ordenacionPorApellido(List<Alumno> listaAlumnos, String archivo){
        List<Alumno> ordenApellido = listaAlumnos.stream()
                .sorted(Comparator.comparing(Alumno::getApellido))
                .collect(Collectors.toList());
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo))) {
            escribir.write(ordenApellido.stream().map(Alumno::toString).collect(Collectors.toList()));
        } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
            return;
        }
    }
}

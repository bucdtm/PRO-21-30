package Ficheros6;

import Ficheros4.Libro;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Ficheros6 {
    static final String ARCHIVO = "alumnos.csv";
    static final String ARCHIVO2 = "alumnosOrdenados.txt";
    static void main() {
        List<Alumno> alumnos = alumnosParseados(ARCHIVO);
        ordenacionPorApellido(alumnos, ARCHIVO2);



    }
    static List<Alumno> alumnosParseados(String archivo){
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            return lector.lines()
                    .map(linea -> {
                        String[] partes = linea.split(";");

                        //Sara;Lopez Green;32;7;10;6;7,4;7,5;8,5
                        double[] notas = new double[partes.length-3];
                        for (int i = 0; i < notas.length; i++) {
                            notas[i] = Double.parseDouble(partes[i+3].replace(",", "."));
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
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo, false))) {
            escribir.write("apellido;nombre;edad;nota1;nota2;nota3;nota4;nota5;nota6;");
            escribir.newLine();
            for(Alumno alumno : ordenApellido){
                escribir.write(alumno.toString());
                escribir.newLine();
            }
//                try {
//                    escribir.write(String.valueOf(ordenApellido.stream().map(Alumno::toString).collect(Collectors.toList())));
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
            } catch (IOException e) {
            System.err.println("Error al escribir en el fichero: " + e.getMessage());
            }
    }
    static void alumnosEstadisticas(List<Alumno> listaAlumnos, String archivo){
        int notas
    }
}

package Ficheros4;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Ficheros4 {

    public static void main(String[] args) {
        try {
            List<Libro> libros = leerArchivoYProcesarLibros("libros.txt");
            guardarLibrosOrdenados(libros, "libros_ordenados.txt");
            guardarEstadisticas(libros, "estadisticas.txt");
        } catch (IOException e) {
            System.err.println("Error manejando archivos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    private static List<Libro> leerArchivoYProcesarLibros(String archivo) throws IOException {
        return Files.lines(Paths.get(archivo))
                .map(linea -> {
                    String[] partes = linea.split(";");
                    if (partes.length != 3) throw new IllegalArgumentException("Formato inválido: " + linea);
                    return new Libro(partes[0], partes[1], Double.parseDouble(partes[2]));
                })
                .collect(Collectors.toList());
    }

    private static void guardarLibrosOrdenados(List<Libro> libros, String archivo) throws IOException {
        List<Libro> ordenados = libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo).reversed())
                .collect(Collectors.toList());
        Files.write(Paths.get(archivo),
                ordenados.stream().map(Libro::toString).collect(Collectors.toList()));
    }

    private static void guardarEstadisticas(List<Libro> libros, String archivo) throws IOException {
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparing(Libro::getPrecio));
        double promedioPrecios = libros.stream()
                .mapToDouble(Libro::getPrecio)
                .average()
                .orElse(0.0);

        List<String> estadisticas = new ArrayList<>();
        libroMasCaro.ifPresent(caro -> estadisticas.add(
                "Libro más caro: " + caro.getTitulo() + " por " + caro.getAutor() + " - $" + caro.getPrecio()));
        estadisticas.add("Precio promedio: $" + promedioPrecios);

        Files.write(Paths.get(archivo), estadisticas);
    }

}

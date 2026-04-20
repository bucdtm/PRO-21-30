package Ficheros4;


import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ficheros4 {

    public static void main(String[] args) {
        try {
            // Leer archivo de libros, procesar y obtener la lista de libros
            List<Libro> libros = leerArchivoYProcesarLibros("libros.txt");
            // Guardar libros ordenados en un archivo
            guardarLibrosOrdenados(libros, "libros_ordenados.txt");
            // Guardar estadísticas de los libros en otro archivo
            guardarEstadisticas(libros, "estadisticas.txt");
        } catch (IOException e) {
            System.err.println("Error manejando archivos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    // Lee un archivo de texto y convierte cada línea en un objeto Libro
    private static List<Libro> leerArchivoYProcesarLibros(String archivo) throws IOException {
        return Files.lines(Paths.get(archivo))
                .map(linea -> {
                    // Divide la línea en partes y crea un objeto Libro
                    String[] partes = linea.split(";");
                    if (partes.length != 3) throw new IllegalArgumentException("Formato inválido: " + linea);
                    return new Libro(partes[0], partes[1], Double.parseDouble(partes[2].replace(",", ".")));
                })
                .collect(Collectors.toList());
    }

    // Ordena la lista de libros por título (descendente) y guarda en un archivo
    private static void guardarLibrosOrdenados(List<Libro> libros, String archivo) throws IOException {
        List<Libro> ordenados = libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo).reversed())
                .collect(Collectors.toList());
        Files.write(Paths.get(archivo),
                ordenados.stream().map(Libro::toString).collect(Collectors.toList()));
    }

    // Calcula estadísticas de los libros y las guarda en un archivo
    private static void guardarEstadisticas(List<Libro> libros, String archivo) throws IOException {
        // Busca el libro más caro
        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparing(Libro::getPrecio));
        // Calcula el precio promedio de los libros
        double promedioPrecios = libros.stream()
                .mapToDouble(Libro::getPrecio)
                .average()
                .orElse(0.0);

        List<String> estadisticas = new ArrayList<>();
        // Agrega el libro más caro a la lista de estadísticas, si existe
        libroMasCaro.ifPresent(caro -> estadisticas.add(
                "Libro más caro: " + caro.getTitulo() + " por " + caro.getAutor() + " - $" + caro.getPrecio()));
        // Agrega el precio promedio
        estadisticas.add("Precio promedio: $" + promedioPrecios);

        Files.write(Paths.get(archivo), estadisticas);
    }

}
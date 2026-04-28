package Ficheros6;

import Ficheros4.Libro;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Ficheros6 {
    static final String ARCHIVO = "alumnos.csv";
    static final String ARCHIVO2 = "alumnosOrdenados.csv";
    static final String ARCHIVO3 = "alumnosEstadisticas.txt";
    static final String ARCHIVO4 = "alumnosBuenos.txt";
    static void main() {
        List<Alumno> alumnos = alumnosParseados(ARCHIVO);
        if (!alumnos.isEmpty()) {
            ordenacionPorApellido(alumnos, ARCHIVO2);
            alumnosEstadisticas(alumnos, ARCHIVO3);
            alumnosBuenos(alumnos, ARCHIVO4);
            System.out.println("Proceso finalizado");
        }



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
        BufferedWriter escribir = null;
        try {
            escribir = new BufferedWriter(new FileWriter(archivo));

            long totalAprobados = listaAlumnos.stream().filter(Alumno::todoAprobado).count();
            escribir.write("1. Número de alumnos con todo aprobado: " + totalAprobados);
            escribir.newLine();

            escribir.write("2. Alumnos con todo aprobado (ordenados):");
            escribir.newLine();
            List<Alumno> aprobadosOrdenados = listaAlumnos.stream()
                    .filter(Alumno::todoAprobado)
                    .sorted(Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre))
                    .collect(Collectors.toList());
            for (Alumno a : aprobadosOrdenados) {
                escribir.write("   - " + a.getNombre() + " " + a.getApellido());
                escribir.newLine();
            }

            List<Alumno> entre30y70 = listaAlumnos.stream()
                    .filter(a -> a.getEdad() >= 30 && a.getEdad() <= 70)
                    .collect(Collectors.toList());
            double media30y70 = entre30y70.stream().mapToInt(Alumno::getEdad).average().orElse(0);
            escribir.write(String.format("3. Alumnos entre 30 y 70 años: %d (Media de edad: %.2f)", entre30y70.size(), media30y70));
            escribir.newLine();

            List<Alumno> mayores90 = listaAlumnos.stream()
                    .filter(a -> a.getEdad() > 90)
                    .collect(Collectors.toList());
            double media90 = mayores90.stream().mapToInt(Alumno::getEdad).average().orElse(0);
            escribir.write(String.format("4. Alumnos de mas de 90 años: %d (Media de edad: %.2f)", mayores90.size(), media90));
            escribir.newLine();

            long pasanCurso = listaAlumnos.stream().filter(a -> a.suspensos() <= 2).count();
            escribir.write("5. Número de alumnos que pasan de curso (max 2 suspensos): " + pasanCurso);
            escribir.newLine();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // AQUÍ ESTÁ LA MAGIA: Obligamos a cerrar y guardar el archivo
            if (escribir != null) {
                try {
                    escribir.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

    static void alumnosBuenos(List<Alumno> listaAlumnos, String archivo) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(archivo));

            pw.println("1. Alumnos con notas iguales o superiores a 7 en todos los modulos:");
            PrintWriter finalPw = pw;
            listaAlumnos.stream()
                    .filter(Alumno::todoNotableOSuperior)
                    .forEach(a -> finalPw.printf("   - Nombre: %s | Nota Media: %.2f%n", a.getNombre(), a.notaMedia()));

            Alumno mejor = listaAlumnos.stream()
                    .max(Comparator.comparingDouble(Alumno::notaMedia))
                    .orElse(null);
            if (mejor != null) {
                pw.println("2. Alumno con la mejor nota media:");
                pw.printf("   - %s %s (Media: %.2f)%n", mejor.getNombre(), mejor.getApellido(), mejor.notaMedia());
            }

            Alumno peor = listaAlumnos.stream()
                    .min(Comparator.comparingDouble(Alumno::notaMedia))
                    .orElse(null);
            if (peor != null) {
                pw.println("3. Alumno con la peor nota media:");
                pw.printf("   - %s %s (Media: %.2f)%n", peor.getNombre(), peor.getApellido(), peor.notaMedia());
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cerramos el PrintWriter para que vuelque los datos al archivo
            if (pw != null) {
                pw.close();
            }
        }
    }
}

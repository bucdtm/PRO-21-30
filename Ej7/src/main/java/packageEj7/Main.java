package packageEj7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Path rutaCSV = Paths.get("platos.csv");
        // Definimos la ruta de salida
        Path rutaJSON = Paths.get("platos_final.json");

        List<Plato> listaPlatos = new ArrayList<>();

        try {
            // 1. Lectura
            List<String> lineas = Files.readAllLines(rutaCSV);

            // 2. Procesamiento (mismo que antes)
            for (int i = 1; i < lineas.size(); i++) {
                String[] datos = lineas.get(i).split(";");

                Plato plato = new Plato();
                plato.setNombre(datos[0]);
                int prep = Integer.parseInt(datos[1]);
                int cook = Integer.parseInt(datos[2]);
                plato.setTiempoTotal(prep + cook);

                Map<String, Integer> desgloseTiempos = new LinkedHashMap<>();
                desgloseTiempos.put("Preparacion", prep);
                desgloseTiempos.put("Coccion", cook);
                plato.setDesgloseTiempos(desgloseTiempos);

                Map<String, String> nutricion = new LinkedHashMap<>();
                nutricion.put("Calorías", datos[3] + " kcal");
                nutricion.put("Fibra", datos[4] + "g");

                String hierro = datos[5].trim().toLowerCase();
                String hierroTraducido = hierro.equals("alto") ? "high" : (hierro.equals("bajo") ? "low" : "medium");
                nutricion.put("Hierro", hierroTraducido);

                plato.setNutricion(nutricion);
                listaPlatos.add(plato);
            }

            // 3. Serialización
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonFinal = gson.toJson(listaPlatos);

            // 🎯 ZONA CLAVE: Escritura de un archivo de texto (Exportación)
            // Files.writeString toma la ruta, el contenido y (opcionalmente) la codificación.
            // Crea el archivo si no existe o lo sobreescribe si ya existe.
            Files.writeString(rutaJSON, jsonFinal);

            System.out.println("¡Éxito! El archivo JSON ha sido generado en: " + rutaJSON.toAbsolutePath());

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        }
    }

}

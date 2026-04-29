package packageEj8;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Ejecución del flujo
        List<Empleado> empleados = leerEmpleadosDesdeJson("empleados_input.json");

        if (empleados != null) {
            // 3. Serializar con Pretty Print
            guardarJson(empleados, "empleados.json");

            // 4. Corregir texto (B <-> V) sin deserializar
            corregirCiudadesEnArchivo("empleados.json");

            // 5. Deserializar el corregido para verificar y Ampliaciones
            String rutaCorregida = obtenerRutaConVersion("empleados_corregido", "json");
            List<Empleado> empleadosCorregidos = leerEmpleadosDesdeJson(rutaCorregida);

            System.out.println("--- LISTA CORREGIDA ---");
            empleadosCorregidos.forEach(System.out::println);

            // Ampliación 2: Conteo por color de ojos (Programación Funcional)
            System.out.println("\n--- CONTEO POR COLOR DE OJOS ---");
            // 🎯 ZONA CLAVE: Streams para agrupar y contar
            Map<ColorOjos, Long> conteoOjos = empleadosCorregidos.stream()
                    .collect(Collectors.groupingBy(Empleado::getColorOjos, Collectors.counting()));
            conteoOjos.forEach((color, total) -> System.out.println(color + ": " + total));

            // Ampliación 3: Mayores de 30 años
            // 🎯 ZONA CLAVE: Filter y Collect en Streams
            List<Empleado> mayores30 = empleadosCorregidos.stream()
                    .filter(e -> e.getEdad() > 30)
                    .collect(Collectors.toList());
            guardarJson(mayores30, "empleados_mayores_30.json");
        }
    }

    // 2. Método de lectura
    // 🎯 ZONA CLAVE: Uso de TypeToken para deserializar Listas Genéricas
    public static List<Empleado> leerEmpleadosDesdeJson(String ruta) {
        try {
            String json = Files.readString(Paths.get(ruta));
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Empleado>>() {}.getType();
            return gson.fromJson(json, listType);
        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
            return null;
        }
    }

    public static void guardarJson(List<?> lista, String nombreArchivo) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Files.writeString(Paths.get(nombreArchivo), gson.toJson(lista));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 4. Corrección de texto pura (Intercambio B por V)
    public static void corregirCiudadesEnArchivo(String rutaOrigen) {
        try {
            String contenido = Files.readString(Paths.get(rutaOrigen));

            // 🎯 ZONA CLAVE: El truco del "Placeholder" para intercambiar caracteres
            // Si cambias B por V directamente, luego al cambiar V por B, todo será B.
            // Usamos un paso intermedio.
            String corregido = contenido
                    .replace("B", "###TEMP_V###") // B temporalmente es otra cosa
                    .replace("V", "B")            // Las V pasan a ser B
                    .replace("###TEMP_V###", "V") // Las antiguas B pasan a ser V
                    .replace("v", "b")            // Opcional: manejar minúsculas
                    .replace("b", "v");

            String nuevaRuta = obtenerRutaConVersion("empleados_corregido", "json");
            Files.writeString(Paths.get(nuevaRuta), corregido);
            System.out.println("\nArchivo corregido guardado como: " + nuevaRuta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Ampliación 1: Control de versiones
    public static String obtenerRutaConVersion(String baseName, String extension) {
        int version = 1;
        Path path;
        do {
            path = Paths.get(baseName + "_v" + version + "." + extension);
            version++;
        } while (Files.exists(path));

        // Retornamos la última que NO existía o la anterior si queremos sobreescribir.
        // Para este ejercicio, devolvemos la versión actual que se ha comprobado.
        return baseName + "_v" + (version - 1) + "." + extension;
    }

}

package ochoApellidosPackage;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClaseAuxiliarRegistroApellidos {

    private Map<String, List<Apellido>> mapApellidos; // funciona guardando

    public ClaseAuxiliarRegistroApellidos() {
        this.mapApellidos = new HashMap<>();
    }


    public void cargarProvincia(String provincia, String... apellidosStrArgs) { // metodo aprendido para juntar elementos de una misma categoria en un metodo (infinitos)
        if (apellidosStrArgs.length != 8) {
            System.out.println("error,  " + provincia);
            return;
        }

        List<Apellido> listaApellidos = new ArrayList<>();
        for (String ap : apellidosStrArgs) {
            listaApellidos.add(new Apellido(ap));
        }

        mapApellidos.put(provincia, listaApellidos);
    }

    private static List<Apellido> ordenarApellidosBurbuja(List<Apellido> apellidos) {
        int n = apellidos.size();
        boolean intercambiado;

        for (int i = 0; i < n - 1; i++) {
            intercambiado = false;
            // recorre la lista restando los elementos ya ordenados al final
            for (int j = 0; j < n - i - 1; j++) {
                String actual = apellidos.get(j).getApellido();
                String siguiente = apellidos.get(j + 1).getApellido();

                // compara ignorando mayúsculas (orden descendente en este caso)
                if (actual.compareToIgnoreCase(siguiente) < 0) {
                    // intercambia posiciones usando una variable temporal
                    Apellido temp = apellidos.get(j);
                    apellidos.set(j, apellidos.get(j + 1));
                    apellidos.set(j + 1, temp);

                    intercambiado = true; // marca que hubo cambios en esta pasada
                }
            }
            // si no hubo intercambios, la lista ya está lista
            if (!intercambiado) break;
        }

        return apellidos;
    }

    public void mostrarDatosOrdenados() {
        System.out.println("--- APELLIDOS ORDENADOS POR BURBUJA (Orden Invertido) ---");
        for (Map.Entry<String, List<Apellido>> entrada : mapApellidos.entrySet()) {
            System.out.println("\nProvincia: " + entrada.getKey());

            List<Apellido> listaOrdenada = ordenarApellidosBurbuja(entrada.getValue());

            for (Apellido ap : listaOrdenada) {
                System.out.println(" - " + ap.getApellido());
            }
        }
    }

    public static void main(String[] args) {
        ClaseAuxiliarRegistroApellidos gestor = new ClaseAuxiliarRegistroApellidos();

        gestor.cargarProvincia("Gipuzkoa", "Zubizarreta", "Aguirre", "Belastegui", "Gabilondo", "Iturbe", "Ochotorena", "Salazar", "Elezcano");
        gestor.cargarProvincia("Bizkaia", "Abasolo", "Urrutia", "Echevarría", "Goikoetxea", "Ibarra", "Lertxundi", "Mendizabal", "Zallo");
        gestor.cargarProvincia("Araba", "Vitoria", "Ortiz de Zárate", "Orueta", "Gámiz", "Basterra", "Amescua", "Zárate", "Uribe");

        gestor.mostrarDatosOrdenados();
    }
}
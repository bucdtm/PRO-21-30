package concesionarioPaquete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Concesionario {

    public static void listarNuevoVehiculo(ArrayList<Vehiculo> vehiculos){
        Scanner sc = new Scanner(System.in);

        String marca = FuncionesCall.pedirConValidacion(sc, "Marca:", ".+");
        String modelo = FuncionesCall.pedirConValidacion(sc, "Modelo:", ".+");
        String color = FuncionesCall.pedirConValidacion(sc, "Color:", ".+");
        String matricula = FuncionesCall.pedirConValidacion(sc, "Matrícula:", "^[0-9]{4}[A-Z]{3}$");
        int km = FuncionesCall.pedirEnteroPositivo(sc, "Kilometraje:");
        int precio = FuncionesCall.pedirEnteroPositivo(sc, "Precio:");
        String descripcion = FuncionesCall.pedirConValidacion(sc, "Descripcion:", ".+");

        int resultado = insertarVehiculo(vehiculos,marca,modelo,color,matricula,km,precio,descripcion);

        if (resultado == 0) System.out.println("Vehículo añadido.");
        else if (resultado == -1) System.out.println("Concesionario lleno.");
        else if (resultado == -2) System.out.println("Matrícula ya existe.");

    }

    public static int insertarVehiculo(ArrayList<Vehiculo> vehiculos, String marca, String modelo, String color, String matricula, int km, int precio, String descripcion){
        if (vehiculos.size() >= 50){
            return -1;
        }

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)){
                return -2;
            }
        }

        vehiculos.add(new Vehiculo(marca,modelo,color,matricula,km,precio,descripcion));
        return 0;
    }

    public static void listaVehiculos(ArrayList<Vehiculo> vehiculos) {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
    }

    public static void listaVehiculosOrdenados(ArrayList<Vehiculo> vehiculos) {
        Comparator<Vehiculo> comparador = new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                if (o1.getMarca().compareTo(o2.getMarca()) != 0){
                    return o1.getMarca().compareTo(o2.getMarca());
                } else if (o1.getModelo().compareTo(o2.getModelo()) != 0) {
                    return o1.getModelo().compareTo(o2.getModelo());
                } else {
                    return Integer.compare(o1.getKm(), o2.getKm());
                }
            }
        };
        Collections.sort(vehiculos, comparador);
        listaVehiculos(vehiculos);
    }

    static void listarVehiculosMenoresCienMilKilometros(ArrayList<Vehiculo> vehiculos) {
        ArrayList<Vehiculo> vehiculosMenoresCienMilKilometros = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getKm() < 100000) {
                vehiculosMenoresCienMilKilometros.add(vehiculo);
            }
        }
        listaVehiculos(vehiculosMenoresCienMilKilometros);
    }

    static String buscarVehiculo(ArrayList<Vehiculo> vehiculos, String matricula) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                return vehiculo.toString();
            }
        }
        return null;
    }

    static boolean actualizaKms(ArrayList<Vehiculo> vehiculos, String matricula, int nuevoKilometraje){
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getMatricula().equals(matricula)) {
                vehiculo.setKm(nuevoKilometraje);
                return true;
            }
        }
        return false;
    }

}

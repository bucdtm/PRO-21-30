package concesionario.concesionarioPaquete;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        ArrayList vehiculos = new ArrayList<>();

        vehiculos.add(new Concesionario("Toyota", "Corolla", "Blanco", "1234ABC", 15000, 50000, "Sedán compacto en buen estado."));
        vehiculos.add(new Concesionario("Toyota", "RAV4", "Negro", "5678DEF", 22000, 30000, "SUV espacioso y eficiente."));
        vehiculos.add(new Concesionario("Ford", "Focus", "Rojo", "9101GHI", 12000, 60000, "Económico y ágil en la ciudad."));
        vehiculos.add(new Concesionario("Ford", "Mustang", "Azul", "1122JKL", 35000, 20000, "Deportivo con gran potencia."));
        vehiculos.add(new Concesionario("Honda", "Civic", "Gris", "3344MNO", 18000, 45000, "Confiable y con bajo consumo de combustible."));
        vehiculos.add(new Concesionario("Honda", "CR-V", "Plateado", "5566PQR", 25000, 25000, "SUV ideal para la familia."));
        vehiculos.add(new Concesionario("BMW", "Serie 3", "Negro", "7788STU", 30000, 20000, "Sedán premium con gran desempeño."));
        vehiculos.add(new Concesionario("BMW", "X5", "Blanco", "9900VWX", 50000, 15000, "SUV de lujo con tecnología avanzada."));
        vehiculos.add(new Concesionario("Mercedes", "Clase A", "Gris", "1111YZA", 32000, 18000, "Compacto pero con gran lujo."));
        vehiculos.add(new Concesionario("Mercedes", "GLC", "Negro", "2222BCD", 48000, 12000, "SUV elegante con alto rendimiento."));
        vehiculos.add(new Concesionario("Nissan", "Sentra", "Azul", "3333EFG", 16000, 40000, "Sedán espacioso y eficiente."));
        vehiculos.add(new Concesionario("Nissan", "X-Trail", "Verde", "4444HIJ", 23000, 35000, "SUV versátil para cualquier terreno."));
        vehiculos.add(new Concesionario("Mazda", "CX-5", "Rojo", "5555KLM", 27000, 30000, "SUV deportivo y moderno."));
        vehiculos.add(new Concesionario("Mazda", "Mazda3", "Blanco", "6666NOP", 19000, 50000, "Sedán con excelente manejo."));
        vehiculos.add(new Concesionario("Audi", "A4", "Negro", "7777QRS", 34000, 25000, "Sedán de lujo con gran tecnología."));
        vehiculos.add(new Concesionario("Audi", "Q5", "Gris", "8888TUV", 46000, 20000, "SUV premium con gran confort."));


        do {
            opcion = FuncionesCall.menu(sc);

            switch (opcion) {
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 4 -> System.out.println();
                case 5 -> System.out.println();
                case 6 -> System.out.println();
                default -> System.out.println("Opción no permitida, vuelve a introducir un valor: ");
            }
            if (opcion != 6 || opcion != 1) {
                System.out.println("\nPresiona Enter");
                sc.nextLine();
            }
        } while (opcion != 6);

        sc.close();
    }

}

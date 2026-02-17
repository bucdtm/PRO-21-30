package concesionario.concesionarioPaquete;

import java.util.Scanner;

public class FuncionesCall {
    public static int menu(Scanner sc) {

        System.out.println("========== GESTIÓN DE VEHÍCULOS ==========");
        System.out.println("[1] Nuevo Vehículo");
        System.out.println("[2] Listar Vehículos");
        System.out.println("[3] Listar Vehículos con menos de 100.000 km");
        System.out.println("[4] Buscar Vehículo");
        System.out.println("[5] Modificar km Vehículo");
        System.out.println("[6] Salir");
        System.out.println("==========================================");
        System.out.print("Seleccione una opción (1-6): ");

        int opcion = -1;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Intentalo de nuevo con un número válido.");
        }
        System.out.println();
        return opcion;
    }
}

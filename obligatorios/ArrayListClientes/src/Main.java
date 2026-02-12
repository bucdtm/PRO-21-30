import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) {
        ArrayList<String> clientes = new ArrayList<>();
        clientes.add("Juan");
        clientes.add("Maria");
        clientes.add("Carlos");
        clientes.add("Ana");

        ArrayList<Double> deudas = new ArrayList<>();
        deudas.add(1500.0);
        deudas.add(2300.0);
        deudas.add(1200.0);
        deudas.add(0.0);

        ArrayList<Double> saldo = new ArrayList<>();
        saldo.add(500.00);
        saldo.add(750.25);
        saldo.add(1200.00);
        saldo.add(2000.00);

        char opcion;

        do {
            opcion = Funciones.MostrarMenu();

            switch (opcion) {
                case 'A':
                    System.out.println("--- Has seleccionado: Añadir cliente ---");
                    clientes.add(Funciones.AnyadirCliente(clientes));
                    deudas.add(0.00);
                    saldo.add(0.00);
                    break;
                case 'E':
                    System.out.println("--- Has seleccionado: Eliminar cliente ---");
                    Funciones.EliminarCliente(clientes, deudas, saldo);
                    break;
                case 'D':
                    System.out.println("--- Has seleccionado: Consultar clientes, deudas y saldo ---");
                    Funciones.MostrarListaClienteDeudaSaldo(clientes, deudas, saldo);
                    break;
                case 'M':
                    System.out.println("--- Has seleccionado: Modificar deuda ---");
                    Funciones.ModificarDeuda(clientes, deudas, saldo);
                    break;
                case 'X':
                    System.out.println("--- Has seleccionado: Modificar saldo ---");
                    Funciones.ModificarSaldo(clientes, saldo);
                    break;
                case 'S':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    if (opcion != ' ') {
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                    }
            }
            System.out.println();

        } while (opcion != 'S');

        scanner.close();
    }



}
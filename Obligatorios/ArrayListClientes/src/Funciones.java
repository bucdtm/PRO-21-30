import java.util.ArrayList;
import java.util.Scanner;



public class Funciones {
    // --- FUNCIONES ---

    public static String AnyadirCliente(ArrayList<String> clientes) {
        String respuesta = "";
        boolean validar = false;
        System.out.println();
        MostrarCliente(clientes);
        System.out.println();
        while (!validar) {
            System.out.println("Escriba el nombre del cliente que quiere añadir:");
            respuesta = Main.scanner.nextLine();
            boolean existe = false;
            for (String cliente : clientes) {
                if (respuesta.equalsIgnoreCase(cliente)) {
                    existe = true;
                    break;
                }
            }
            if (existe) {
                System.out.println("¡Error! El cliente ya existe. Intente otro nombre.");
            } else {
                validar = true;
            }
        }
        return respuesta;
    }

    public static void EliminarCliente(ArrayList<String> clientes, ArrayList<Double> deudas, ArrayList<Double> saldo) {
        String respuesta = "";
        boolean encontrado = false;

        System.out.println();
        MostrarCliente(clientes);
        System.out.println();

        while (!encontrado) {
            System.out.println("Escriba el nombre del cliente a eliminar (o 'salir' para cancelar):");
            respuesta = Main.scanner.nextLine();

            if (respuesta.equalsIgnoreCase("salir")) break;

            int index = -1;
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).equalsIgnoreCase(respuesta)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                if (deudas.get(index) > 0) {
                    System.out.println("No puedes eliminar a " + clientes.get(index) + " porque tiene deuda pendiente.");
                    encontrado = true;
                } else {
                    System.out.println("Eliminando a " + clientes.get(index) + "...");
                    clientes.remove(index);
                    deudas.remove(index);
                    saldo.remove(index);
                    encontrado = true;
                }
            } else {
                System.out.println("¡Error! El cliente NO existe. Intente otro nombre.");
            }
        }
    }

    public static void ModificarDeuda(ArrayList<String> clientes, ArrayList<Double> deudas, ArrayList<Double> saldo) {
        String respuesta = "";
        boolean validar = false;
        int posicionEnElArray = -1;

        System.out.println();
        MostrarCliente(clientes);
        MostrarValorDecididoEnMetodo(deudas);
        System.out.println();

        while (!validar) {
            System.out.println("Escriba el nombre del cliente (o 'salir'):");
            respuesta = Main.scanner.nextLine();
            if (respuesta.equalsIgnoreCase("salir")) return;

            posicionEnElArray = -1;
            for (int i = 0; i < clientes.size(); i++) {
                if (respuesta.equalsIgnoreCase(clientes.get(i))) {
                    posicionEnElArray = i;
                    break;
                }
            }

            if (posicionEnElArray != -1) {
                System.out.println("Escriba la cantidad a sumar (positivo) o restar (negativo):");
                try {
                    double valor = Double.parseDouble(Main.scanner.nextLine());
                    double nuevaDeuda = deudas.get(posicionEnElArray) + valor;

                    if (nuevaDeuda < 0) {
                        deudas.set(posicionEnElArray, deudas.get(posicionEnElArray) + valor);
                        if (deudas.get(posicionEnElArray) < 0)
                            saldo.set(posicionEnElArray, saldo.get(posicionEnElArray)-nuevaDeuda);
                            deudas.set(posicionEnElArray, 0.0);
                            System.out.println("Le ha sobrado dinero del pago de deuda!");
                            System.out.println();
                            System.out.println("Su nuevo saldo es de: " + saldo.get(posicionEnElArray));
                    } else {
                        deudas.set(posicionEnElArray, nuevaDeuda);
                        System.out.println("Deuda actualizada.");
                    }
                    validar = true;
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido.");
                }
            } else {
                System.out.println("El cliente no existe.");
            }
        }
    }

    public static void ModificarSaldo(ArrayList<String> clientes, ArrayList<Double> saldo) {
        String respuesta = "";
        boolean validar = false;
        int posicionEnElArray = -1;

        System.out.println();
        MostrarCliente(clientes);
        MostrarValorDecididoEnMetodo(saldo);
        System.out.println();

        while (!validar) {
            System.out.println("Escriba el nombre del cliente para modificar saldo (o 'salir'):");
            respuesta = Main.scanner.nextLine();
            if (respuesta.equalsIgnoreCase("salir")) return;

            posicionEnElArray = -1;
            for (int i = 0; i < clientes.size(); i++) {
                if (respuesta.equalsIgnoreCase(clientes.get(i))) {
                    posicionEnElArray = i;
                    break;
                }
            }

            if (posicionEnElArray != -1) {
                System.out.println("Escriba la cantidad a Ingresar (positivo) o Retirar (negativo):");
                try {
                    double valor = Double.parseDouble(Main.scanner.nextLine());

                    double nuevoSaldo = saldo.get(posicionEnElArray) + valor;

                    saldo.set(posicionEnElArray, nuevoSaldo);
                    System.out.println("Saldo actualizado: " + nuevoSaldo + "€");
                    validar = true;

                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduzca un número válido.");
                }
            } else {
                System.out.println("¡Error! El cliente NO existe.");
            }
        }
    }

    public static void MostrarListaClienteDeudaSaldo(ArrayList<String> clientes, ArrayList<Double> deudas,  ArrayList<Double> saldo) {
        System.out.println("------------------------------------------");
        System.out.printf("%-20s %-10s %s\n", "Cliente", "Deuda", "Saldo");
        System.out.println("------------------------------------------");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.printf("%-20s %-10.2f€ %.2f€\n", clientes.get(i), deudas.get(i), saldo.get(i));
        }
        System.out.println("------------------------------------------");
    }

    public static char MostrarMenu() {

        System.out.println("========== GESTIÓN DE CLIENTES ==========");
        System.out.println("[A] Añadir cliente");
        System.out.println("[E] Eliminar cliente");
        System.out.println("[D] Consultar clientes, deudas y saldo");
        System.out.println("[M] Modificar la deuda de un cliente");
        System.out.println("[X] Modificar el saldo cliente");
        System.out.println("[S] Salir");
        System.out.println("=========================================");
        System.out.print("Seleccione una opción: ");
        String entrada = Main.scanner.nextLine();

        if (entrada.isEmpty()) {
            return ' ';
        }
        return entrada.toUpperCase().charAt(0);
    }

    public static void MostrarCliente(ArrayList<String> clientes) {
        System.out.println("Clientes actuales: " + clientes);
    }

    public static void MostrarValorDecididoEnMetodo(ArrayList<Double> ValorDecidido) {
        System.out.println("Valores actuales: " + ValorDecidido);
    }
}

package SalvarLaVerbena;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mezclador miMezclador = new Mezclador();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("\n--- 🎛️ MESA DE MEZCLAS ---");
            System.out.println("1. ▶️ Darle gas (Siguiente)");
            System.out.println("2. 📝 Apuntar petición (Final)");
            System.out.println("3. 🕵️ COLAR canción (En medio)");
            System.out.println("4. 🕵️ COLAR VIP (La siguiente)");
            System.out.println("5. 👀 Ver lista");
            System.out.println("6. 🔌 Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        miMezclador.darleAlPlay();
                        break;
                    case 2:
                        miMezclador.apuntarPeticion();
                        break;
                    case 3:
                        miMezclador.colarCancionEnchufado();
                        break;
                    case 4:
                        miMezclador.colarCancionVip();
                        break;
                    case 5:
                        miMezclador.imprimirLista();
                        break;
                    case 6:
                        System.out.println("Programa Cerrado...");
                        break;
                    default:
                        System.out.println("Opción no válida, elige entre 1 y 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }

        } while (opcion != 6);

        sc.close();
    }
}
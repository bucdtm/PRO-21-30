package SalvarLaVerbena;

import java.util.LinkedList;
import java.util.Scanner;

class Mezclador {
    public LinkedList<Cancion> listaDeReproduccion;
    public static Scanner sc = new Scanner(System.in);

    public Mezclador(){
        this.listaDeReproduccion = new LinkedList<>();
        cargarClasicos();
    }
    public void cargarClasicos(){
        listaDeReproduccion.add(new Cancion("Paquito el Chocolatero", "King África"));
        listaDeReproduccion.add(new Cancion("Flying Free", "Pont Aeri"));
        listaDeReproduccion.add(new Cancion("Sarandonga", "Lolita"));
    }
    public void darleAlPlay() {
        if (listaDeReproduccion.isEmpty()) {
            System.out.println("No quedan canciones");
        } else {
            Cancion proxima = listaDeReproduccion.poll();
            System.out.println("Sonando... " + proxima);
        }
    }

    public void apuntarPeticion() {
        System.out.print("Introduce el título: ");
        String titulo = sc.nextLine();
        System.out.print("Introduce el artista: ");
        String artista = sc.nextLine();

        listaDeReproduccion.addLast(new Cancion(titulo, artista));
        System.out.println("Petición añadida");
        imprimirLista();
    }

    public void colarCancionEnchufado() {
        System.out.print("Introduce el título (Enchufado): ");
        String titulo = sc.nextLine();
        System.out.print("Introduce el artista (Enchufado): ");
        String artista = sc.nextLine();

        int mitad = listaDeReproduccion.size() / 2;
        listaDeReproduccion.add(mitad, new Cancion(titulo, artista));

        System.out.println("Canción colada a mitad de lista");
        imprimirLista();
    }

    public void colarCancionVip() {
        System.out.print("Introduce el título (VIP): ");
        String titulo = sc.nextLine();
        System.out.print("Introduce el artista (VIP): ");
        String artista = sc.nextLine();

        listaDeReproduccion.addFirst(new Cancion(titulo, artista));

        System.out.println("Marchando una para el VIP");
        imprimirLista();
    }

    public void imprimirLista() {
        if (listaDeReproduccion.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("--- Lista de Reproducción Actual ---");
            for (int i = 0; i < listaDeReproduccion.size(); i++) {
                System.out.println((i + 1) + ". " + listaDeReproduccion.get(i));
            }
        }
    }
}

import java.util.Scanner;

public class RuletaRusaMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a la Ruleta Rusa.");
        System.out.println("Introduce número de jugadores (1-6): ");

        int numeroJugadores = 0;
        try {
            numeroJugadores = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            numeroJugadores = 6;
        }

        Juego juego = new Juego(numeroJugadores);

        while (!juego.finJuego()) {
            juego.ronda();
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Fin del juego.");
        sc.close();
    }
}
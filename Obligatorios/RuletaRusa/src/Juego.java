import java.util.Random;

public class Juego {
    private Jugador[] jugadores;
    private Revolver revolver;
    private int turno; // Índice del jugador al que le toca

    public Juego(int numJugadores) {
        if (numJugadores < 1 || numJugadores > 6) {
            numJugadores = 6;
        }

        jugadores = new Jugador[numJugadores];
        revolver = new Revolver();

        for (int i = 0; i < numJugadores; i++) {
            jugadores[i] = new Jugador(i + 1);
        }

        Random random = new Random();
        this.turno = random.nextInt(numJugadores);
        System.out.println("Sorteo inicial: Empieza el " + jugadores[turno].getNombre());
    }

    public boolean finJuego() {
        for (Jugador j : jugadores) {
            if (!j.estaVivo()) {
                return true;
            }
        }
        return false;
    }

    public void ronda() {
        Jugador jugadorActual = jugadores[turno];

        jugadorActual.disparar(revolver);

        if (!finJuego()) {
            turno++;
            if (turno >= jugadores.length) {
                turno = 0;
            }
        }
    }
}
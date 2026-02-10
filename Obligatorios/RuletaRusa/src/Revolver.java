import java.util.Random;

class Revolver {
    private int posicionActual;
    private int posicionBala;

    public Revolver() {
        inicializarPosiciones();
    }

    private void inicializarPosiciones() {
        Random random = new Random();
        this.posicionActual = random.nextInt(6) + 1;
        this.posicionBala = random.nextInt(6) + 1;
    }

    public boolean disparar() {
        boolean exito = (posicionActual == posicionBala);
        return exito;
    }

    public void siguienteBala() {
        if (posicionActual == 6) {
            posicionActual = 1;
        } else {
            posicionActual++;
        }
    }

    @Override
    public String toString() {
        return "Revolver [Posición Tambor: " + posicionActual +
                " | Posición Bala: " + posicionBala + "]";
    }
}
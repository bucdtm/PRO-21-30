public class Jugador {
    private int id;
    private String nombre;
    private boolean vivo;

    public Jugador(int id) {
        this.id = id;
        this.nombre = "Jugador " + id;
        this.vivo = true;
    }

    public void disparar(Revolver r) {
        System.out.println("-------------------------------------------------");
        System.out.println(this.nombre + " se apunta con el revólver...");

        boolean murio = r.disparar();

        if (murio) {
            this.vivo = false;
            System.out.println("¡BANG! " + this.nombre + " ha muerto.");
        } else {
            System.out.println("¡Click! " + this.nombre + " ha tenido suerte. Sigue vivo.");
        }

        System.out.println("Info: " + r.toString());

        if (!murio) {
            r.siguienteBala();
        }
    }

    public boolean estaVivo() {
        return vivo;
    }

    public String getNombre() {
        return nombre;
    }
}
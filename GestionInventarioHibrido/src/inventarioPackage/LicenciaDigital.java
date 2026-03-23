package inventarioPackage;

public class LicenciaDigital implements Vendible{
    String nombreServicio;
     boolean canjeada;

    public LicenciaDigital(String nombreServicio, boolean canjeada) {
        this.nombreServicio = nombreServicio;
        this.canjeada = false;
    }

    @Override
    public void realizarVenta() {
        if (!canjeada) {
            canjeada = true;
        } else {
            System.err.println("Error: La licencia ["+nombreServicio+"] ya ha sido usada");
        }
    }

    @Override
    public boolean estaDisponible() {
        if (!canjeada) {
            return false;
        } else {
            return false;
        }
    }
}

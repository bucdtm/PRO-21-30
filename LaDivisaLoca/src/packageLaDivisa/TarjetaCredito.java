package packageLaDivisa;

public class TarjetaCredito extends MetodoPago {
    private String numeroTarjeta;

    public TarjetaCredito(double monto, String numeroTarjeta) {
        super(monto);
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    protected boolean validar() {
        // Valida que no sea nulo y contenga exactamente 16 dígitos
        return numeroTarjeta != null && numeroTarjeta.matches("\\d{16}");
    }

    @Override
    protected double calcularComision() {
        return (monto * 0.03) + 0.50; // 3% + $0.50 fijos
    }
}

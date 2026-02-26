package packageLaDivisa;

public class Criptomoneda extends MetodoPago {
    private String wallet;

    public Criptomoneda(double monto, String wallet) {
        super(monto);
        this.wallet = wallet;
    }

    @Override
    protected boolean validar() {
        return wallet != null && wallet.startsWith("0x");
    }

    @Override
    protected double calcularComision() {
        // Genera un porcentaje aleatorio entre 0.01 (1%) y 0.05 (5%)
        double porcentajeGas = 0.01 + (Math.random() * 0.04);
        return monto * porcentajeGas;
    }
}

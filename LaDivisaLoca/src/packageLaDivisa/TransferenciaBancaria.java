package packageLaDivisa;

public class TransferenciaBancaria extends MetodoPago {
    public TransferenciaBancaria(double monto) {
        super(monto);
    }

    @Override
    protected boolean validar() {
        return monto > 500.0;
    }

    @Override
    protected double calcularComision() {
        return 2.00; // Coste fijo
    }
}
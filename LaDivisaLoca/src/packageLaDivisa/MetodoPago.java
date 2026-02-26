package packageLaDivisa;

public abstract class MetodoPago {
    protected double monto;

    public MetodoPago(double monto) {
        this.monto = monto;
    }

    // Contrato para las clases hijas
    protected abstract boolean validar();
    protected abstract double calcularComision();

    // Método Plantilla: Está protegido con 'final' para que las hijas NO puedan sobrescribirlo ni romper el flujo
    public final void ejecutarFinal() {
        // REFLEXIÓN Pura: El objeto se interroga a sí mismo en tiempo de ejecución
        String nombreClase = this.getClass().getSimpleName();

        try {
            if (validar()) {
                double total = monto + calcularComision();
                // Formateamos a 2 decimales para que se vea como dinero real
                System.out.printf("[OK] Procesando %s... Total final: $%.2f%n", nombreClase, total);
            } else {
                System.out.printf("[ERROR] Validación de negocio fallida para %s.%n", nombreClase);
            }
        } catch (Exception e) {
            System.out.printf("[ERROR FATAL] Excepción inesperada en %s: %s%n", nombreClase, e.getMessage());
        }
    }
}

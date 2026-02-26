package packageLaDivisa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- INICIANDO MOTOR DE PAGOS ---\n");

        List<MetodoPago> transacciones = new ArrayList<>();

        // 1. Tarjeta de Crédito (Éxito y Fallo)
        transacciones.add(new TarjetaCredito(100.0, "1234567812345678")); // OK: 16 dígitos
        transacciones.add(new TarjetaCredito(150.0, "1234ABCD"));         // ERROR: Letras y muy corto

        // 2. Criptomoneda (Éxito y Fallo)
        transacciones.add(new Criptomoneda(300.0, "0xABC123DEF456"));     // OK: Empieza con 0x
        transacciones.add(new Criptomoneda(500.0, "bc1qxy2kgdygjrsqtz")); // ERROR: No empieza con 0x

        // 3. Transferencia Bancaria (Éxito y Fallo)
        transacciones.add(new TransferenciaBancaria(1000.0));             // OK: Mayor a 500
        transacciones.add(new TransferenciaBancaria(499.99));             // ERROR: Menor o igual a 500

        // EJECUCIÓN POLIMÓRFICA
        for (MetodoPago pago : transacciones) {
            // El bucle ignora el tipo concreto. Invoca el contrato general.
            pago.ejecutarFinal();
        }

        System.out.println("\n--- PROCESAMIENTO FINALIZADO ---");
    }
}
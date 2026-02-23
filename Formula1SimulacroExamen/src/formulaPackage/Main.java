package formulaPackage;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MiembroEquipo> listadoParticipantes = new ArrayList<>();
// --- 15 PILOTOS (MotoGP) ---
        listadoParticipantes.add(new Piloto("Jorge Martín", 26, 5000000.0, 89, "Pramac Racing", 508));
        listadoParticipantes.add(new Piloto("Francesco Bagnaia", 27, 6000000.0, 1, "Ducati Lenovo", 498));
        listadoParticipantes.add(new Piloto("Marc Márquez", 31, 10000000.0, 93, "Gresini Racing", 392));
        listadoParticipantes.add(new Piloto("Enea Bastianini", 26, 3000000.0, 23, "Ducati Lenovo", 386));
        listadoParticipantes.add(new Piloto("Brad Binder", 28, 2500000.0, 33, "KTM Factory", 217));
        listadoParticipantes.add(new Piloto("Pedro Acosta", 19, 1200000.0, 31, "GasGas Tech3", 215));
        listadoParticipantes.add(new Piloto("Maverick Viñales", 29, 4000000.0, 12, "Aprilia Racing", 190));
        listadoParticipantes.add(new Piloto("Aleix Espargaró", 34, 3500000.0, 41, "Aprilia Racing", 163));
        listadoParticipantes.add(new Piloto("Fabio Di Giannantonio", 25, 1200000.0, 49, "VR46 Racing", 165));
        listadoParticipantes.add(new Piloto("Franco Morbidelli", 29, 1500000.0, 21, "Pramac Racing", 173));
        listadoParticipantes.add(new Piloto("Marco Bezzecchi", 25, 2000000.0, 72, "VR46 Racing", 153));
        listadoParticipantes.add(new Piloto("Alex Márquez", 28, 1800000.0, 73, "Gresini Racing", 173));
        listadoParticipantes.add(new Piloto("Fabio Quartararo", 25, 8000000.0, 20, "Yamaha Factory", 113));
        listadoParticipantes.add(new Piloto("Jack Miller", 29, 2000000.0, 43, "KTM Factory", 87));
        listadoParticipantes.add(new Piloto("Miguel Oliveira", 29, 1500000.0, 88, "Trackhouse Racing", 75));
// --- 5 INGENIEROS ---
        listadoParticipantes.add(new Ingeniero("Gigi Dall'Igna", 58, 2500000.0, "Aerodinámica", "Ducati", 35));
        listadoParticipantes.add(new Ingeniero("Santi Hernández", 48, 950000.0, "Telemetría", "Gresini", 20));
        listadoParticipantes.add(new Ingeniero("Christian Gabarrini", 51, 980000.0, "Electrónica", "Ducati", 25));
        listadoParticipantes.add(new Ingeniero("Alberto Puig", 57, 1100000.0, "Estrategia", "Honda", 30));
        listadoParticipantes.add(new Ingeniero("Massimo Rivola", 52, 1050000.0, "Chasis", "Aprilia", 22));

        GranPremio.ordenarParrilla();
        GranPremio.mostrarParticipantes(listadoParticipantes);
        GranPremio.simularCarrera();
        GranPremio.mostrarResultados();


    }
}

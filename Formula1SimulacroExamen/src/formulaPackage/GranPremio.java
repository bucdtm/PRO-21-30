package formulaPackage;

import java.util.*;
import java.util.stream.Collectors;

public class GranPremio {
    private static String nombreCircuito;
    private static List<MiembroEquipo> participantes;
    private static List<Piloto> parrillaSalida = new ArrayList<>();
    private static List<Ingeniero> ingenierosCarrera = new ArrayList<>();
    private static List<String> abandonos = new ArrayList<>();
    private static Map<String, Integer> rendimientoTotalAcumulado = new HashMap<>();

    public GranPremio(String nombreCircuito) {
        this.nombreCircuito = nombreCircuito;
        this.participantes = listaInicial();

        for (MiembroEquipo separacion : participantes) {
            if (separacion instanceof Piloto) {
                parrillaSalida.add((Piloto) separacion);
            } else if (separacion instanceof Ingeniero) {
                ingenierosCarrera.add((Ingeniero) separacion);
            }
        }

        Collections.sort(ingenierosCarrera);

        int limitePilotos = Math.min(parrillaSalida.size(), 10);
        int limiteIngenieros = Math.min(ingenierosCarrera.size(), 3);

        parrillaSalida = new ArrayList<>(parrillaSalida.subList(0, limitePilotos));
        ingenierosCarrera = new ArrayList<>(ingenierosCarrera.subList(0, limiteIngenieros));
    }

    public static void ordenarParrilla() {
        Collections.sort(parrillaSalida);
    }

    public static void mostrarResultados() {
        System.out.println();
        System.out.println("Pilotos Carrera Terminada: ");
        for (Piloto pilotoCarreraTerminada : parrillaSalida) {
            System.out.printf("Nombre: %-20s | Dorsal: %-3d%n",
                    pilotoCarreraTerminada.getNombre(),
                    pilotoCarreraTerminada.getDorsal()
            );
        }

        System.out.println();
        System.out.println("Ingenieros Carrera: ");
        for (Ingeniero ingeniero : ingenierosCarrera) {
            System.out.printf("Nombre: %-20s | Especialidad: %-20s%n",
                    ingeniero.getNombre(),
                    ingeniero.getEspecialidad()
            );
        }

        System.out.println();
        System.out.println("Rendimiento total: ");

        Map<String, Integer> rendimientoAcumuladoOrdenado = rendimientoTotalAcumulado.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        int i = 1;
        for (Map.Entry<String, Integer> entry : rendimientoAcumuladoOrdenado.entrySet()) {
            System.out.println(i + "º Posicion - " + entry.getKey() + " - Puntaje: " + entry.getValue());
            i++;
        }

        System.out.println();
        System.out.println("Abandonos:");
        for (String pilotoAbandonado : abandonos) {
            System.out.printf("- Piloto eliminado/abandonado: %s%n", pilotoAbandonado);
        }
    }

    public static void mostrarParticipantes() {
        System.out.println("Pilotos: ");
        System.out.println();
        for (Piloto piloto : parrillaSalida) {
            System.out.printf("Nombre: %-20s | Dorsal: %-3d | Escudería: %-20s | Puntos: %d%n",
                    piloto.getNombre(),
                    piloto.getDorsal(),
                    piloto.getEscuderia(),
                    piloto.getPuntosCampeonato()
            );
        }

        System.out.println();
        System.out.println("Ingenieros: ");
        System.out.println();
        for (Ingeniero ingeniero : ingenierosCarrera) {
            System.out.printf("Nombre: %-20s | Especialidad: %-20s | Experiencia: %-20s%n",
                    ingeniero.getNombre(),
                    ingeniero.getEspecialidad(),
                    ingeniero.getExperiencia()
            );
        }
    }

    public static void simularCarrera() {
        Random random = new Random();
        System.out.println();
        for (int i = 0; i < 50; i++) {
            Iterator<Piloto> it = parrillaSalida.iterator();
            String resultado;

            while (it.hasNext()) {
                Piloto piloto = it.next();
                resultado = piloto.realizarTarea();

                switch (resultado) {
                    case "Accidente" -> {
                        System.out.println("Piloto Fuera de Juego: " + piloto.getNombre());
                        abandonos.add((piloto.getNombre()));
                        it.remove();
                        break;
                    }
                    case "Entrada a Boxes" -> {
                        // Comprobación de seguridad por si no hay ingenieros
                        if (!ingenierosCarrera.isEmpty()) {
                            Ingeniero ingeniero = ingenierosCarrera.get(random.nextInt(ingenierosCarrera.size()));
                            if (ingeniero.aportarMejora() < 0) {
                                System.out.println("Coche del piloto muy roto, Piloto eliminado: " + piloto.getNombre());
                                abandonos.add((piloto.getNombre()));
                                it.remove();
                            } else {
                                piloto.setDesgasteNeumaticos(20);
                            }
                        }
                        break;
                    }
                    case "Vuelta Limpia" -> {
                        int vueltaCompeticion = piloto.competir();
                        if (rendimientoTotalAcumulado.get(piloto.getNombre()) == null) {
                            rendimientoTotalAcumulado.put(piloto.getNombre(), vueltaCompeticion);
                        } else {
                            int puntosAnteriores = rendimientoTotalAcumulado.get(piloto.getNombre());
                            rendimientoTotalAcumulado.put(piloto.getNombre(), puntosAnteriores + vueltaCompeticion);
                        }
                        break;
                    }
                }
            }
        }
    }

    public List<MiembroEquipo> listaInicial(){
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
        return listadoParticipantes;
    }
}
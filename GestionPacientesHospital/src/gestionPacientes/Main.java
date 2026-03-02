package gestionPacientes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    // Estructuras de datos obligatorias
    private static Set<PacienteBase> pacientesRegistrados = new HashSet<>();
    private static Map<String, List<PacienteVisita>> historialVisitas = new HashMap<>();

    // Colas de atención
    private static Queue<PacienteVisita> colaLeves = new LinkedList<>();
    private static Queue<PacienteVisita> colaModerados = new LinkedList<>();
    private static Queue<PacienteVisita> colaGraves = new LinkedList<>();

    // Contador para la reevaluación automática
    private static int pacientesAtendidos = 0;

    // Listas de datos simulados para autocompletar diagnósticos
    private static List<String> diagnosticos = Arrays.asList("Gripe", "Fisura", "Gastroenteritis", "Ansiedad", "Migraña");
    private static List<String> medicos = Arrays.asList("Dra. García", "Dr. López", "Dra. Martínez", "Dr. House");
    private static List<String> tratamientos = Arrays.asList("Paracetamol", "Ibuprofeno", "Reposo", "Antibiótico", "Escayola");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 8) {
            System.out.println("\n--- GESTIÓN DE URGENCIAS HOSPITALARIAS ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Crear nueva visita");
            System.out.println("3. Atender al siguiente paciente");
            System.out.println("4. Re-evaluar manualmente prioridad (Extra)");
            System.out.println("5. Consultar historial de un paciente");
            System.out.println("6. Mostrar todos los pacientes e historiales");
            System.out.println("7. Mostrar estado de las colas");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> registrarPaciente(scanner);
                    case 2 -> crearNuevaVisita(scanner);
                    case 3 -> atenderSiguiente();
                    case 4 -> reevaluarManual(scanner);
                    case 5 -> consultarHistorial(scanner);
                    case 6 -> mostrarPacientesYHistoriales();
                    case 7 -> mostrarEstadoColas();
                    case 8 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor introduce un número válido.");
            }
        }
        scanner.close();
    }

    // 1. Registrar Paciente
    private static void registrarPaciente(Scanner scanner) {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Fecha de nacimiento (DD-MM-YYYY): ");
            LocalDate fechaNac = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            System.out.print("Teléfono (9 dígitos): ");
            String telefono = scanner.nextLine();

            PacienteBase nuevoPaciente = new PacienteBase(id, nombre, apellidos, fechaNac, telefono);

            if (pacientesRegistrados.add(nuevoPaciente)) {
                historialVisitas.put(id, new ArrayList<>()); // Creación INICIAL de su historial
                System.out.println("Paciente registrado con éxito.");
            } else {
                System.out.println("Error: Ya existe un paciente con ese ID.");
                // Mostrar su historial hasta el momento si ya existe
                System.out.println("Historial actual: " + historialVisitas.get(id));
            }
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println("Error al registrar paciente: " + e.getMessage());
        }
    }

    // 2. Crear nueva visita
    private static void crearNuevaVisita(Scanner scanner) {
        System.out.print("Introduce el ID del paciente: ");
        String id = scanner.nextLine();

        PacienteBase pacienteEncontrado = pacientesRegistrados.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (pacienteEncontrado == null) {
            System.out.println("Error: El paciente con ID " + id + " no está registrado.");
            return;
        }

        try {
            System.out.print("Prioridad (1-10): ");
            int prioridad = Integer.parseInt(scanner.nextLine());
            System.out.print("Motivo de la visita: ");
            String motivo = scanner.nextLine();

            PacienteVisita nuevaVisita = new PacienteVisita(
                    id, LocalDateTime.now(), null, prioridad, motivo,
                    null, null, null, false,
                    diagnosticos, medicos, tratamientos
            );

            historialVisitas.get(id).add(nuevaVisita);

            if (prioridad == 10) {
                System.out.println("¡Prioridad CRÍTICA! Atendiendo inmediatamente...");
                atenderSiguiente(nuevaVisita);
            } else {
                encolarVisita(nuevaVisita);
                System.out.println("Visita registrada y encolada según prioridad.");
            }

        } catch (Exception e) {
            System.out.println("Error al crear visita: " + e.getMessage());
        }
    }

    // Lógica para meter en la cola correcta
    private static void encolarVisita(PacienteVisita visita) {
        int prio = visita.getPrioridad();
        if (prio >= 1 && prio <= 3) colaLeves.add(visita);
        else if (prio >= 4 && prio <= 6) colaModerados.add(visita);
        else if (prio >= 7 && prio <= 9) colaGraves.add(visita);
    }

    // 3. Atender al siguiente paciente (Atención normal)
    private static void atenderSiguiente() {
        PacienteVisita pacienteAAtender = null;

        if (!colaGraves.isEmpty()) pacienteAAtender = colaGraves.poll();
        else if (!colaModerados.isEmpty()) pacienteAAtender = colaModerados.poll();
        else if (!colaLeves.isEmpty()) pacienteAAtender = colaLeves.poll();

        if (pacienteAAtender != null) {
            atenderSiguiente(pacienteAAtender);
        } else {
            System.out.println("No hay pacientes en espera en ninguna cola.");
        }
    }

    // Sobrecarga: Atender un paciente específico (Atención directa o sacado de cola)
    private static void atenderSiguiente(PacienteVisita pacienteVisita) {
        pacienteVisita.atenderPaciente(LocalDateTime.now());
        System.out.println("Paciente atendido: " + pacienteVisita.getId());
        System.out.println("Diagnóstico: " + pacienteVisita.getDiagnostico());
        System.out.println("Tratamiento: " + pacienteVisita.getTratamiento());
        System.out.println("Médico: " + pacienteVisita.getMedicoResponsable());

        pacientesAtendidos++;
        if (pacientesAtendidos % 5 == 0) {
            reevaluacionAutomatica();
        }
    }

    // Extra: Reevaluación automática cada 5 pacientes
    private static void reevaluacionAutomatica() {
        System.out.println("\n[!] Ejecutando reevaluación automática de prioridades...");
        List<PacienteVisita> aReencolar = new ArrayList<>();

        aReencolar.addAll(colaLeves);
        aReencolar.addAll(colaModerados);

        colaLeves.clear();
        colaModerados.clear();

        for (PacienteVisita v : aReencolar) {
            v.setPrioridad(v.getPrioridad() + 1);
            if (v.getPrioridad() == 10) {
                System.out.println("[!] Paciente " + v.getId() + " ha alcanzado prioridad 10. Atención inmediata.");
                atenderSiguiente(v);
            } else {
                encolarVisita(v);
            }
        }
    }

    // 4. Re-evaluar manualmente prioridad (Extra)
    private static void reevaluarManual(Scanner scanner) {
        System.out.print("ID del paciente a reevaluar: ");
        String id = scanner.nextLine();

        // Buscar la visita no atendida de este paciente
        List<PacienteVisita> visitas = historialVisitas.get(id);
        if (visitas == null || visitas.isEmpty()) {
            System.out.println("No hay visitas para este paciente.");
            return;
        }

        PacienteVisita visitaPendiente = visitas.stream()
                .filter(v -> !v.isAtendido())
                .findFirst()
                .orElse(null);

        if (visitaPendiente == null) {
            System.out.println("El paciente no tiene visitas pendientes en cola.");
            return;
        }

        // Eliminar de su cola actual
        colaLeves.remove(visitaPendiente);
        colaModerados.remove(visitaPendiente);
        colaGraves.remove(visitaPendiente);

        System.out.print("Nueva prioridad (1-10): ");
        int nuevaPrioridad = Integer.parseInt(scanner.nextLine());
        visitaPendiente.setPrioridad(nuevaPrioridad);

        if (nuevaPrioridad == 10) {
            atenderSiguiente(visitaPendiente);
        } else {
            encolarVisita(visitaPendiente);
            System.out.println("Prioridad actualizada y reencolado.");
        }
    }

    // 5. Consultar historial de un paciente
    private static void consultarHistorial(Scanner scanner) {
        System.out.print("ID del paciente: ");
        String id = scanner.nextLine();
        List<PacienteVisita> historial = historialVisitas.get(id);

        if (historial != null) {
            System.out.println("Historial de " + id + ":");
            historial.forEach(System.out::println);
        } else {
            System.out.println("Paciente no encontrado o sin historial.");
        }
    }

    // 6. Mostrar pacientes y sus historiales
    private static void mostrarPacientesYHistoriales() {
        if (pacientesRegistrados.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        for (PacienteBase p : pacientesRegistrados) {
            System.out.println(p.toString());
            System.out.println("   Visitas: " + historialVisitas.get(p.getId()).size());
        }
    }

    // 7. Mostrar estado actual de las colas
    private static void mostrarEstadoColas() {
        System.out.println("--- ESTADO DE LAS COLAS ---");
        System.out.println("Graves (7-9): " + colaGraves.size() + " pacientes");
        System.out.println("Moderados (4-6): " + colaModerados.size() + " pacientes");
        System.out.println("Leves (1-3): " + colaLeves.size() + " pacientes");
    }
}
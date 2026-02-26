package gestionPacientesPolimorfismo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class GestorUrgencias {

    // Estructuras de datos obligatorias [cite: 13, 17, 21, 24]
    private static Set<PacienteBase> pacientesRegistrados = new HashSet<>();
    private static Map<String, List<PacienteVisita>> historialVisitas = new HashMap<>();
    private static Queue<PacienteVisita> colaAtencion = new PriorityQueue<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;
        do {
            System.out.println("\n--- GESTIÓN DE URGENCIAS HOSPITALARIAS ---");
            System.out.println("1. Registrar paciente"); // [cite: 89]
            System.out.println("2. Crear nueva visita"); // [cite: 90]
            System.out.println("3. Atender al siguiente paciente"); // [cite: 91]
            System.out.println("4. Consultar historial completo de un paciente"); // [cite: 92]
            System.out.println("5. Mostrar pacientes y sus historiales"); // [cite: 93]
            System.out.println("6. Mostrar estado actual de las colas"); // [cite: 94]
            System.out.println("7. Salir"); // [cite: 96]
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1 -> registrarPaciente();
                    case 2 -> crearVisita();
                    case 3 -> atenderSiguiente();
                    case 4 -> consultarHistorial();
                    case 5 -> mostrarPacientes();
                    case 6 -> mostrarEstadoColas();
                    case 7 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduzca un número válido.");
            }
        } while (opcion != 7);
    }

    // 1. REGISTRAR PACIENTE [cite: 98-102]
    private static void registrarPaciente() {
        try {
            System.out.print("ID del paciente: ");
            String id = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
            LocalDate fechaNac = LocalDate.parse(scanner.nextLine());
            System.out.print("Teléfono: ");
            String telefono = scanner.nextLine();

            PacienteBase nuevoPaciente = new PacienteBase(id, nombre, apellidos, fechaNac, telefono);

            if (pacientesRegistrados.add(nuevoPaciente)) {
                // Creación INICIAL de su historial si no existe [cite: 101]
                historialVisitas.put(id, new ArrayList<>());
                System.out.println("Paciente registrado con éxito.");
            } else {
                System.out.println("El paciente con ID " + id + " ya está registrado. Historial hasta el momento: " + historialVisitas.get(id)); // [cite: 101, 102]
            }
        } catch (IllegalArgumentException | DateTimeParseException e) {
            System.out.println("Error al registrar: " + e.getMessage()); // [cite: 102]
        }
    }

    // 2. CREAR NUEVA VISITA [cite: 103-111]
    private static void crearVisita() {
        System.out.print("Introduzca el ID del paciente: "); // [cite: 105]
        String id = scanner.nextLine();

        // Búsqueda en la estructura [cite: 106, 107, 108]
        PacienteBase pacienteEncontrado = pacientesRegistrados.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (pacienteEncontrado == null) {
            System.out.println("Error: Paciente no encontrado. Debe registrarlo primero."); // [cite: 108]
            return;
        }

        try {
            System.out.print("Motivo de la visita: ");
            String motivo = scanner.nextLine();
            System.out.print("Prioridad (1-10): ");
            int prioridad = Integer.parseInt(scanner.nextLine());

            PacienteVisita nuevaVisita = null;

            // Instanciar según prioridad [cite: 68]
            if (prioridad >= 1 && prioridad <= 3) {
                nuevaVisita = new PacienteLeve(id, prioridad, motivo);
            } else if (prioridad >= 4 && prioridad <= 6) {
                nuevaVisita = new PacienteModerado(id, prioridad, motivo);
            } else if (prioridad >= 7 && prioridad <= 10) {
                nuevaVisita = new PacienteGrave(id, prioridad, motivo);
            } else {
                System.out.println("Prioridad inválida. Debe ser entre 1 y 10.");
                return;
            }

            // Añadir al historial [cite: 110, 111]
            historialVisitas.get(id).add(nuevaVisita);
            System.out.println("Protocolo activado: " + nuevaVisita.obtenerProtocoloAtencion());

            // Atención directa vs Encolar [cite: 69, 70, 111, 112]
            if (prioridad == 10) {
                System.out.println("¡ALERTA! Prioridad 10. Atención directa iniciada.");
                atenderSiguiente(nuevaVisita);
            } else {
                colaAtencion.offer(nuevaVisita);
                System.out.println("Visita encolada correctamente.");
            }

        } catch (Exception e) {
            System.out.println("Error al crear visita: " + e.getMessage());
        }
    }

    // 3. ATENDER AL SIGUIENTE PACIENTE (Sobrecarga de métodos) [cite: 115-123]
    private static void atenderSiguiente() {
        PacienteVisita visita = colaAtencion.poll(); // Extrae el de mayor prioridad [cite: 116, 117]
        if (visita != null) {
            visita.atenderPaciente(LocalDateTime.now()); // [cite: 118, 119]
            System.out.println("Se ha atendido al paciente ID: " + visita.getId() + " con prioridad " + visita.getPrioridad());
        } else {
            System.out.println("No hay pacientes en la cola de espera.");
        }
    }

    private static void atenderSiguiente(PacienteVisita pacienteVisita) { // Variante para críticos [cite: 121, 122]
        pacienteVisita.atenderPaciente(LocalDateTime.now()); // [cite: 118, 119]
        System.out.println("Paciente CRÍTICO (ID: " + pacienteVisita.getId() + ") ha sido atendido instantáneamente.");
    }

    // 4. CONSULTAR HISTORIAL
    private static void consultarHistorial() {
        System.out.print("ID del paciente para consultar: ");
        String id = scanner.nextLine();
        List<PacienteVisita> historial = historialVisitas.get(id);

        if (historial != null) {
            System.out.println("Historial del paciente " + id + ":");
            historial.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron registros para ese ID.");
        }
    }

    // 5. MOSTRAR PACIENTES Y SUS HISTORIALES
    private static void mostrarPacientes() {
        if (pacientesRegistrados.isEmpty()) {
            System.out.println("No hay pacientes registrados en el sistema.");
            return;
        }
        for (PacienteBase p : pacientesRegistrados) {
            System.out.println(p);
            System.out.println("   Visitas: " + historialVisitas.get(p.getId()));
        }
    }

    // 6. MOSTRAR ESTADO ACTUAL DE LAS COLAS
    private static void mostrarEstadoColas() {
        if (colaAtencion.isEmpty()) {
            System.out.println("La cola de atención está vacía.");
        } else {
            System.out.println("Estado actual de la cola (por orden de prioridad):");
            colaAtencion.forEach(System.out::println);
        }
    }
}

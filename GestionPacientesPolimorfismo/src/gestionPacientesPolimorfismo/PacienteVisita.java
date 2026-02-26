package gestionPacientesPolimorfismo;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class PacienteVisita implements Comparable<PacienteVisita> {
    protected String id;
    protected LocalDateTime fechaEntrada;
    protected LocalDateTime fechaSalida;
    protected int prioridad; // [1-10] [cite: 45]
    protected String motivo;
    protected String diagnostico;
    protected String tratamiento;
    protected String medicoResponsable;
    protected boolean atendido;

    // Listas para obtener datos aleatorios
    private static final List<String> DIAGNOSTICOS = Arrays.asList("Infección viral", "Esguince", "Migraña", "Fractura", "Crisis de ansiedad");
    private static final List<String> MEDICOS = Arrays.asList("Dr. García", "Dra. Martínez", "Dr. López", "Dra. Sánchez");
    private static final List<String> TRATAMIENTOS = Arrays.asList("Paracetamol", "Reposo y hielo", "Antibióticos", "Inmovilización", "Observación");

    public PacienteVisita(String id, int prioridad, String motivo) {
        // Validación de id y prioridad [cite: 54]
        if (id == null || id.trim().isEmpty() || prioridad < 1 || prioridad > 10) {
            throw new IllegalArgumentException("ID inválido o prioridad fuera de rango (1-10).");
        }
        this.id = id;
        this.prioridad = prioridad;
        this.motivo = motivo;
        this.fechaEntrada = LocalDateTime.now();
        this.atendido = false;
    }

    // Método abstracto (polimorfismo) [cite: 53, 54]
    public abstract String obtenerProtocoloAtencion();

    // Método para completar la visita [cite: 55, 56, 118, 119]
    public void atenderPaciente(LocalDateTime fecha) {
        Random random = new Random();
        this.fechaSalida = fecha;
        this.diagnostico = DIAGNOSTICOS.get(random.nextInt(DIAGNOSTICOS.size()));
        this.tratamiento = TRATAMIENTOS.get(random.nextInt(TRATAMIENTOS.size()));
        this.medicoResponsable = MEDICOS.get(random.nextInt(MEDICOS.size()));
        this.atendido = true;
    }

    public String getId() { return id; }
    public int getPrioridad() { return prioridad; }

    // Ordenar en la cola: mayor prioridad primero [cite: 116, 117]
    @Override
    public int compareTo(PacienteVisita otro) {
        return Integer.compare(otro.prioridad, this.prioridad);
    }

    @Override
    public String toString() {
        return "Visita [Prioridad=" + prioridad + ", Motivo=" + motivo + ", Atendido=" + atendido + ", Medico=" + medicoResponsable + "]";
    }
}
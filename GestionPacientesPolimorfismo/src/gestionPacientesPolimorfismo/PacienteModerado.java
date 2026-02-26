package gestionPacientesPolimorfismo;

public class PacienteModerado extends PacienteVisita {
    public PacienteModerado(String id, int prioridad, String motivo) {
        super(id, prioridad, motivo);
    }

    @Override
    public String obtenerProtocoloAtencion() {
        return "Asignación de box intermedio. Revisión de signos cada 30 min."; // [cite: 61]
    }
}



package gestionPacientesPolimorfismo;

public class PacienteLeve extends PacienteVisita {
    public PacienteLeve(String id, int prioridad, String motivo) {
        super(id, prioridad, motivo);
    }

    @Override
    public String obtenerProtocoloAtencion() {
        return "Espera en sala general. Tiempo estimado: 120 min."; // [cite: 58]
    }
}


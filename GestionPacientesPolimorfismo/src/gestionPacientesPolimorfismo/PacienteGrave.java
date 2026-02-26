package gestionPacientesPolimorfismo;

public class PacienteGrave extends PacienteVisita {
    public PacienteGrave(String id, int prioridad, String motivo) {
        super(id, prioridad, motivo);
    }

    @Override
    public String obtenerProtocoloAtencion() {
        return "TRASLADO INMEDIATO A REANIMACIÓN. Alerta a equipo de guardia."; // [cite: 65]
    }
}

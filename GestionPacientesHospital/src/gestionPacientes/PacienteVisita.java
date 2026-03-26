package gestionPacientes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PacienteVisita {
    Random random = new Random();

    String id;
    LocalDateTime fechaEntrada;
    LocalDateTime fechaSalida;
    int prioridad;
    String motivo;
    String diagnostico;
    String tratamiento;
    String medicoResponsable;
    boolean atendido;

    List<String> diagnosticos, medicos, tratamientos = new ArrayList<>();

    public PacienteVisita(String id, LocalDateTime fechaEntrada, LocalDateTime fechaSalida, int prioridad,
                          String motivo, String diagnostico, String tratamiento,
                          String medicoResponsable, boolean atendido, List<String> diagnosticos,
                          List<String> medicos, List<String> tratamientos) {
        if (id == null || id.isBlank()){
            throw new IllegalArgumentException("El id no puede ser nulo o vacio.");
        }
        if (prioridad <= 0 && prioridad >= 10){
            throw new IllegalArgumentException("La prioridad no puede estar vacia o ser inferior o superior (Rango 1-10)");
        }

        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.prioridad = prioridad;
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.medicoResponsable = medicoResponsable;
        this.atendido = atendido;
        this.diagnosticos = diagnosticos;
        this.medicos = medicos;
        this.tratamientos = tratamientos;
    }

    public void atenderPaciente(LocalDateTime fechaSalida){
        this.fechaSalida = fechaSalida;
        this.atendido = true;

        // Asignar datos aleatorios de las listas (usando .size() es más seguro y limpio)
        if (diagnosticos != null && !diagnosticos.isEmpty()) {
            this.diagnostico = diagnosticos.get(random.nextInt(diagnosticos.size()));
        }
        if (medicos != null && !medicos.isEmpty()) {
            this.medicoResponsable = medicos.get(random.nextInt(medicos.size()));
        }
        if (tratamientos != null && !tratamientos.isEmpty()) {
            this.tratamiento = tratamientos.get(random.nextInt(tratamientos.size()));
        }
    }

    @Override
    public String toString() {
        return "PacienteVisita{" +
                "ID='" + id + '\'' +
                ", Fecha de entrada = " + fechaEntrada +
                ", Fecha de salida = " + fechaSalida +
                ", Prioridad = " + prioridad +
                ", Motivo = ' " + motivo + '\'' +
                ", Diagnostico = '" + diagnostico + '\'' +
                ", Tratamiento = '" + tratamiento + '\'' +
                ", Medico responsable = '" + medicoResponsable + '\'' +
                ", Atendido = " + atendido +
                ", Diagnosticos = " + diagnosticos +
                ", Medicos = " + medicos +
                ", Tratamientos = " + tratamientos +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getMedicoResponsable() {
        return medicoResponsable;
    }

    public void setMedicoResponsable(String medicoResponsable) {
        this.medicoResponsable = medicoResponsable;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(List<String> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public List<String> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<String> medicos) {
        this.medicos = medicos;
    }

    public List<String> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<String> tratamientos) {
        this.tratamientos = tratamientos;
    }


}

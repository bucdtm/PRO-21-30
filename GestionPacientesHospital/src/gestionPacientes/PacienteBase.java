package gestionPacientes;

import java.time.LocalDate;
import java.util.Objects;

public class PacienteBase {
    String id;
    String nombre;
    String apellidos;
    LocalDate fechaNacimiento; // format as DD-MM-YYYY
    String telefono; // format as a regex ^\d{9}$ use function imported from concesionario

    public PacienteBase(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono) {
        if (id == null || id.isBlank()) { // nulo = vacio tho
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacienteBase that = (PacienteBase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ID Paciente: " + id + "\tNombre: " + nombre + "\tApellidos: " + apellidos
                + "\tFecha De Nacimiento: " + fechaNacimiento + "\tTelefono: " + telefono;
    }
}




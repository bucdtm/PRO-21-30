package gestionPacientesPolimorfismo;

import java.time.LocalDate;
import java.util.Objects;

public class PacienteBase {
    private String id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String telefono;

    public PacienteBase(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono) {
        // Validación obligatoria del ID en el constructor [cite: 37, 38, 39]
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del paciente no puede estar en blanco ni ser nulo.");
        }
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getId() { return id; }

    // Sobreescribimos equals y hashCode para que el Set<PacienteBase> evite duplicados
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
        return "PacienteBase{" + "id='" + id + '\'' + ", nombre='" + nombre + " " + apellidos + '\'' + '}';
    }
}

package EjercicioProfesor;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;

public class ProfesorTitular extends Profesor {
    private LocalDate fechaTitularidad;

    public ProfesorTitular(String nombre, String apellido, int edad, LocalDate fechaTitularidad) {
        super(nombre, apellido, edad);
        this.fechaTitularidad = fechaTitularidad;
    }

    public LocalDate getFechaTitularidad() {
        return fechaTitularidad;
    }

    public void setFechaTitularidad(LocalDate fechaTitularidad) {
        this.fechaTitularidad = fechaTitularidad;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("d/MMMM/yyyy", new Locale("es", "ES"));
        System.out.println("Fecha Titularidad: "+fechaTitularidad.format(formateador));
    }
}

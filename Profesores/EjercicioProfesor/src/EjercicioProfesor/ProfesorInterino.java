package EjercicioProfesor;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.LocalDate;

public class ProfesorInterino extends Profesor {
    private LocalDate comienzoInterinidad;

    public ProfesorInterino(String nombre, String apellido, int edad, LocalDate comienzoInterinidad) {
        super(nombre, apellido, edad);
        this.comienzoInterinidad = comienzoInterinidad;
    }

    public LocalDate getComienzoInterinidad() {
        return comienzoInterinidad;
    }

    public void setComienzoInterinidad(LocalDate comienzoInterinidad) {
        this.comienzoInterinidad = comienzoInterinidad;
    }

    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("d/MMMM/yyyy", new Locale("es", "ES"));
        System.out.println("Fecha Comienzo Interinidad: "+ comienzoInterinidad.format(formateador));
    }

}

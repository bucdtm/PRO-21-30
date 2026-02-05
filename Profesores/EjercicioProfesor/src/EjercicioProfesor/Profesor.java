package EjercicioProfesor;

public class Profesor extends Persona {

    private String idProfesor;

    public Profesor(String nombre, String apellido, int edad) {
        super(nombre, apellido, edad);
        this.idProfesor = "Desconocido";
    }

    public String getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void mostrarDatos() {
        System.out.println("Profesor ( " + idProfesor + " )");
        System.out.println(nombre + " " + apellido + " que tiene una edad de  " + edad + " años ");
    }

}

package Ficheros6;

public class Alumno {
    private String nombre;
    private String Apellido;
    private int edad;

    public Alumno(String nombre, String apellido, int edad, int... notasModulo) {
        this.nombre = nombre;
        Apellido = apellido;
        this.edad = edad;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}

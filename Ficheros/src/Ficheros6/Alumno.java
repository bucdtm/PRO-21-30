package Ficheros6;

public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private double[] notasModulo;

    public Alumno(String nombre, String apellido, int edad, double[] notasModulo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.notasModulo = notasModulo;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        String notasFormateadas = "";
        for(double nota : notasModulo){
            notasFormateadas += nota + ";";
        }
        return  apellido + ";" + nombre + ";" + edad + ";"  + notasFormateadas;
    }

    public String datosEstadisticas() {
        String notasFormateadas = "";
        for(double nota : notasModulo){
            notasFormateadas += nota + ";";
        }
        return  apellido + ";" + nombre + ";" + edad + ";"  + notasFormateadas;
    }

    public boolean todoAprobado(){
        for (int i = 0; i < notasModulo.length; i++) {
            if(notasModulo[i] < 5){
                return false;
            }
        }
        return true;
    }
    public double notaMedia(){
        double notaMedia = 0;
        for (int i = 0; i < notasModulo.length; i++) {
            notaMedia += notasModulo[i];
        }
        return notaMedia/notasModulo.length;
    }
}

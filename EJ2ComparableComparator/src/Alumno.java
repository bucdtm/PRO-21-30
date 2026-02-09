public class Alumno implements Comparable{
    int codigo;
    String nombre;
    int edad;
    String curso;

    public Alumno(int codigo, String nombre, int edad, String curso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.edad = edad;
        this.curso = curso;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCurso() {
        return curso;
    }


    @Override
    public void ordenarEdad() {

    }
}

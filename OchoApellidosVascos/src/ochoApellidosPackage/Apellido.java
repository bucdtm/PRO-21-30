package ochoApellidosPackage;

public class Apellido {
    private String apellido;

    public Apellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return apellido;
    }
}

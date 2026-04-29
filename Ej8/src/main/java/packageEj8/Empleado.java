package packageEj8;
// 🎯 ZONA CLAVE: Enums para tipado fuerte. Evita errores de escritura.

public class Empleado {
    private String nombre;
    private int edad;
    private String ciudad;
    private String fechaNacimiento;
    private ColorOjos colorOjos;

    // Constructor, Getters y Setters
    public Empleado() {}

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public ColorOjos getColorOjos() { return colorOjos; }

    @Override
    public String toString() {
        return String.format("Empleado: %-15s | Edad: %d | Ciudad: %-10s | Ojos: %s",
                nombre, edad, ciudad, colorOjos);
    }

}
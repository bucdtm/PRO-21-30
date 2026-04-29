package packageEj7;

import java.util.Map;

public class Plato {
    private String nombre;
    private int tiempoTotal;

    // Uso de Mapas (Clave-Valor) para estructuras dinámicas.
    // Esto permite que el JSON tenga propiedades anidadas que pueden crecer 
    // sin tener que modificar los atributos de esta clase en el futuro.
    private Map<String, Integer> desgloseTiempos;
    private Map<String, String> nutricion;

    // --- Constructores ---
    public Plato() {}

    // --- Getters y Setters ---
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getTiempoTotal() { return tiempoTotal; }
    public void setTiempoTotal(int tiempoTotal) { this.tiempoTotal = tiempoTotal; }

    public Map<String, Integer> getDesgloseTiempos() { return desgloseTiempos; }
    public void setDesgloseTiempos(Map<String, Integer> desgloseTiempos) { this.desgloseTiempos = desgloseTiempos; }

    public Map<String, String> getNutricion() { return nutricion; }
    public void setNutricion(Map<String, String> nutricion) { this.nutricion = nutricion; }
}
package Partido;

import java.util.Objects;

public class Participante {
    String id;
    String nombre;
    int edad;
    String nacionalidad;

    public Participante(String id, String nombre,String nacionalidad , int edad) {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}

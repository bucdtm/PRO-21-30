package Partido;

import java.util.Arrays;
import java.util.Random;

public class Arbitro extends Participante implements Jugable{


    final String[] accionesArbitro = {"ANULAR_CANASTA","ANOTAR_1_PUNTO","ANOTAR_2_PUNTOS","ANOTAR_3_PUNTOS","PASOS","FALTA","EXPULSION"};
    final Random r = new Random();

    String funcion;

    public Arbitro(String id, String nombre,String nacionalidad , int edad) {
        super(id, nombre, nacionalidad, edad);
    }

    @Override
    public String accion() {
        return  accionesArbitro[r.nextInt(0, accionesArbitro.length-1)];
    }

    @Override
    public String toString() {
        return "Arbitro{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nacionalidad='" + nacionalidad + '\'' +
                '}';
    }
}

package Partido;

import java.util.Arrays;
import java.util.Random;

public class JugadorVisitante extends Jugador implements Jugable{
    final Random r = new Random();

    public JugadorVisitante(String id, String nombre,String nacionalidad , int edad, int dorsal, String posicion, boolean expulsado, String equipo, int altura) {
        super(id, nombre, nacionalidad, edad, dorsal, posicion, expulsado, equipo, altura);
    }

    @Override
    public String accion() {
        return accionesJugador[r.nextInt(0, accionesJugador.length-1)];
    }

    @Override
    public String toString() {
        return "JugadorLocal{" +
                ", Nombre=" + nombre +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                ", equipo='" + equipo + '\'' +
                ", altura=" + altura +
                '}';
    }

}

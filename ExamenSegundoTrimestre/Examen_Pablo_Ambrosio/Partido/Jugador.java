package Partido;

import java.util.Arrays;
import java.util.Random;

public class Jugador extends Participante implements Jugable{


    final String[] accionesJugador = {"BOTAR_PELOTA","DRIBLAR","PASAR","TIRO_3_PUNTOS","TIRO_2_PUNTOS","TIRO_1_PUNTO","MATE","COMETER_FALTA"};

    int dorsal;
    String posicion;
    boolean expulsado; // si es true no podra jugar y si es false si
    String equipo;
    int altura; // debe ser en centimetros

    public Jugador(String id, String nombre,String nacionalidad , int edad, int dorsal, String posicion, boolean expulsado, String equipo, int altura) {
        super(id, nombre, nacionalidad, edad);
        this.expulsado = expulsado;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.equipo = equipo;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                ", dorsal=" + dorsal +
                ", posicion='" + posicion + '\'' +
                ", edad=" + edad +
                ", equipo='" + equipo + '\'' +
                ", altura=" + altura +
                '}';
    }

    public String accion(){
        return null;
    }

    public int compareTo(Jugador o) {
        if (Integer.compare(edad, this.edad) != 0){
            return Integer.compare(o.edad, this.edad);
        }
        return CharSequence.compare(this.nacionalidad,o.nacionalidad);
    }

    public String[] getAccionesJugador() {
        return accionesJugador;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isExpulsado() {
        return expulsado;
    }

    public void setExpulsado(boolean expulsado) {
        this.expulsado = expulsado;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}

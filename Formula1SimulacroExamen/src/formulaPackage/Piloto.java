package formulaPackage;

import java.util.Random;

class Piloto extends MiembroEquipo implements Competidor, Comparable<Piloto> {
    int dorsal;
    String escuderia;
    int puntosCampeonato;
    static double desgasteNeumaticos = 20.0;

    static Random random = new Random();

    public Piloto(String nombre, int edad, double sueldoBase, int dorsal, String escuderia, int puntosCampeonato) {
        super(nombre, edad, sueldoBase);
        this.dorsal = dorsal;
        this.escuderia = escuderia;
        this.puntosCampeonato = puntosCampeonato;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPuntosCampeonato() {
        return puntosCampeonato;
    }

    public void setPuntosCampeonato(int puntosCampeonato) {
        this.puntosCampeonato = puntosCampeonato;
    }

    public double getDesgasteNeumaticos() {
        return desgasteNeumaticos;
    }

    public void setDesgasteNeumaticos(double desgasteNeumaticos) {
        this.desgasteNeumaticos = desgasteNeumaticos;
    }


    public static String realizarTarea(){
        int suerte = random.nextInt(-50, 100);
        desgasteNeumaticos = desgasteNeumaticos-2.0;

        if ((suerte + desgasteNeumaticos/4) > 95){
            return "Accidente";
        }
        else if ((suerte+desgasteNeumaticos/4) > 80){
            desgasteNeumaticos = 20.0;
            return "Entrada a Boxes";
        }
        return "Vuelta Limpia";
    }

    public int competir(){
        int numeroAleatorio = random.nextInt(1, 100);
        int bonoExperiencia = this.edad;
        return numeroAleatorio+bonoExperiencia;
    }

    public int compareTo(Piloto o){
        return Integer.compare(this.getPuntosCampeonato(), o.getPuntosCampeonato());
    }

}

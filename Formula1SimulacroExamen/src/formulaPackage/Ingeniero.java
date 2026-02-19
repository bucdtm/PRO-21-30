package formulaPackage;

import java.util.Random;

class Ingeniero extends MiembroEquipo implements Competidor, Comparable<Ingeniero>{
    String especialidad;
    String escuderia;
    int experiencia;

    static Random random = new Random();

    public Ingeniero(String nombre, int edad, double sueldoBase, String especialidad, String escuderia, int experiencia) {
        super(nombre, edad, sueldoBase);
        this.especialidad = especialidad;
        this.escuderia = escuderia;
        this.experiencia = experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int compareTo(Ingeniero o){
        if(Integer.compare(this.getExperiencia(), o.getExperiencia()) != 0) {
            return Integer.compare(this.getExperiencia(), o.getExperiencia());
        }
        return CharSequence.compare(this.getEspecialidad(), o.getEspecialidad());
    }
    public int competir(){
        return 0;
    }

    public int aportarMejora(){
        int bonus = random.nextInt(-50,100);
        return bonus+experiencia;
    }
}

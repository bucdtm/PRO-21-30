package formulaPackage;

import java.util.*;

public class GranPremio {
    private String nombreCircuito;
    private List<MiembroEquipo> participantes;
    private static List<Piloto> parrillaSalida = new ArrayList<>();
    private static List<Ingeniero> ingenierosCarrera = new ArrayList<>();
    private List<String> abandonos;
    private Map<String, Integer> rendimientoTotalAcumulado;

    public GranPremio(String nombreCircuito, ArrayList<MiembroEquipo> participantes) {
        this.nombreCircuito = nombreCircuito;
        this.participantes = participantes;

        for (MiembroEquipo separacion : participantes){
            if (separacion instanceof Piloto){
                parrillaSalida.add((Piloto) separacion);
            } else if (separacion instanceof Ingeniero){
                ingenierosCarrera.add((Ingeniero) separacion);
            }
        }

        Collections.sort(ingenierosCarrera);

        parrillaSalida = new ArrayList<>(parrillaSalida.subList(0,10));
        ingenierosCarrera = new ArrayList<>(ingenierosCarrera.subList(0,3));
    }

    public static void ordenarParrilla(){
        Collections.sort(parrillaSalida);
    }

    public static void mostrarParticipantes(List<MiembroEquipo> participantes){
        for (MiembroEquipo separacion : participantes){
            if (separacion instanceof Piloto){
                parrillaSalida.add((Piloto) separacion);
            } else if (separacion instanceof Ingeniero){
                ingenierosCarrera.add((Ingeniero) separacion);
            }
        }

        System.out.println("Pilotos: ");
        System.out.println();
        for (Piloto piloto : parrillaSalida){
            System.out.println("Nombre: "+piloto.getNombre()+" Dorsal: "+ piloto.getDorsal()+ " Escudería: "+ piloto.getEscuderia()+ " Puntos: "+ piloto.getPuntosCampeonato());

        }
        System.out.println();
        System.out.println("Ingenieros: ");
        System.out.println();
        for (Ingeniero ingeniero : ingenierosCarrera){
            System.out.println("Nombre: "+ingeniero.getNombre()+"\nEspecialidad: "+ingeniero.getEspecialidad()+"\nExperiencia: "+ ingeniero.getExperiencia());
        }


    }

    public static void simularCarrera(List<MiembroEquipo> participantes){
        Iterator<MiembroEquipo> it = participantes.iterator();
        int contador = 0;
        while (it.hasNext() && contador < 50) {

        }




    }

}

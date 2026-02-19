package formulaPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class GranPremio {
    private String nombreCircuito;
    private ArrayList<MiembroEquipo> participantes = new ArrayList<>();
    private ArrayList<Piloto> parrillaSalida = new ArrayList<>();
    private ArrayList<Ingeniero> ingenierosCarrera = new ArrayList<>();
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

        Collections.sort(parrillaSalida);
        Collections.sort(ingenierosCarrera);

        parrillaSalida = new ArrayList<>(parrillaSalida.subList(0,10));
        ingenierosCarrera = new ArrayList<>(ingenierosCarrera.subList(0,3));
    }

    public void ordenarParrilla(){
        Collections.sort(parrillaSalida);
    }

    public void mostrarParticipantes(ArrayList<MiembroEquipo> participantes){
        for (MiembroEquipo separacion : participantes){
            if (separacion instanceof Piloto){
                parrillaSalida.add((Piloto) separacion);
            } else if (separacion instanceof Ingeniero){
                ingenierosCarrera.add((Ingeniero) separacion);
            }
        }
        System.out.println(parrillaSalida);
        System.out.println(ingenierosCarrera);
    }

    public void simularCarrera(){


    }

}

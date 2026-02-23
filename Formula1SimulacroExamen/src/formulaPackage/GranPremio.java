package formulaPackage;

import java.util.*;

public class GranPremio {
    private static String nombreCircuito;
    private static List<MiembroEquipo> participantes;
    private static List<Piloto> parrillaSalida = new ArrayList<>();
    private static List<Ingeniero> ingenierosCarrera = new ArrayList<>();
    private static List<String> abandonos = new ArrayList<>();
    private static Map<String, Integer> rendimientoTotalAcumulado = new  HashMap<>();

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

    public static void mostrarResultados(){
        System.out.println("Pilotos Carrera Terminada: ");
        for (Piloto piloto : parrillaSalida){
            System.out.println("Nombre: "+piloto.getNombre()+" Dorsal: "+ piloto.getDorsal());
        }
        System.out.println("Ingenieros Carrera: ");
        for (Ingeniero ingeniero : ingenierosCarrera){
            System.out.println("Nombre: "+ingeniero.getNombre()+"\nEspecialidad: "+ingeniero.getEspecialidad());
        }
        System.out.println("Rendimiento total: ");
        int i = 1;
        for (String piloto : rendimientoTotalAcumulado.keySet()){
            System.out.println(i + "º"+"Piloto: " + piloto + " puntaje: "+ rendimientoTotalAcumulado.get(piloto));
            i++;
        }
        System.out.println("Abandonos");
        abandonos.stream().forEach(System.out::println);

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

    public static void simularCarrera(){
        Random random = new Random();
        for (int i = 0; i < 50; i++) {

            Iterator<Piloto> it = parrillaSalida.iterator();
            String resultado;

            while(it.hasNext()){
                Piloto piloto = it.next();
                resultado = piloto.realizarTarea();

                switch(resultado){
                    case "Accidente" -> {
                        System.out.println("Piloto Fuera de Juego: "+ piloto.getNombre());
                        abandonos.add(String.valueOf(piloto));
                        it.remove();
                        break;
                    }
                    case "Entrada a Boxes"-> {
                        Ingeniero ingeniero = ingenierosCarrera.get(random.nextInt(ingenierosCarrera.size()));
                        if (ingeniero.aportarMejora() < 0){
                            System.out.println("Coche del piloto muy roto, Piloto eliminado: "+ piloto.getNombre());
                            abandonos.add(String.valueOf(piloto));
                            it.remove();
                        }
                        else {
                            piloto.setDesgasteNeumaticos(20);
                        }
                        break;
                    }
                    case "Vuelta Limpia" -> {
                        int vueltaCompeticion = piloto.competir();
                        if (rendimientoTotalAcumulado.get(piloto.getNombre()) == null){
                            rendimientoTotalAcumulado.put(piloto.getNombre(), vueltaCompeticion);
                        }
                        else {
                            rendimientoTotalAcumulado.put(piloto.getNombre(), piloto.getPuntosCampeonato()+vueltaCompeticion);
                        }
                        break;
                    }
                }
            }
        }
    }
}

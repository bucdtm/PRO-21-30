package Partido;

import java.util.*;
import java.util.stream.Collectors;

public class Partido {
    static List<Participante> participantes = new ArrayList<>();
    static List<JugadorLocal> jugadoresLocales = new ArrayList<>();
    static List<JugadorVisitante> jugadoresVisitantes = new ArrayList<>();
    static List<Arbitro> arbitros = new ArrayList<>();
    static Map<String, List<Integer>> puntuacionesJugador = new HashMap<>();
    static final Random random = new Random();
    static Map<String, List<Integer>> primerCuarto = new HashMap<>();
    static Map<String, List<Integer>> segundoCuarto = new HashMap<>();
    static Map<String, List<Integer>> tercerCuarto = new HashMap<>();
    static Map<String, List<Integer>> cuartoCuarto = new HashMap<>();

    public Partido() {
        rellenarListaParticipantes();
        generarListasParticipantesSeparadas(participantes);
    }

    private void rellenarListaParticipantes() {
       /*
        ESTE MÉTODO NO SE PUEDE MODIFICAR
        */
        // Jugadores Pamesa Valencia (LOCALES)
        Participante jl1 = new JugadorLocal("VLC01", "Víctor Luengo", "Española", 32, 15, "Escolta", false, "Pamesa Valencia", 196);
        Participante jl2 = new JugadorLocal("VLC02", "Nacho Rodilla", "Española", 30, 11, "Base", false, "Pamesa Valencia", 192);
        Participante jl3 = new JugadorLocal("VLC03", "Bernard Hopkins", "USA", 31, 12, "Ala-Pívot", false, "Pamesa Valencia", 197);
        Participante jl4 = new JugadorLocal("VLC01", "Víctor Luengo", "Española", 32, 15, "Escolta", false, "Pamesa Valencia", 196);
        Participante jl5 = new JugadorLocal("VLC04", "Fabricio Oberto", "Argentina", 27, 7, "Pívot", false, "Pamesa Valencia", 208);
        Participante jl6 = new JugadorLocal("VLC05", "Rafa Martínez", "Española", 34, 17, "Escolta", false, "Pamesa Valencia", 190);
        Participante jl7 = new JugadorLocal("VLC06", "Bojan Dubljevic", "Montenegro", 29, 14, "Pívot", false, "Pamesa Valencia", 205);
        Participante jl8 = new JugadorLocal("VLC07", "Dejan Tomasevic", "Serbia", 30, 13, "Pívot", false, "Pamesa Valencia", 208);
        Participante jl9 = new JugadorLocal("VLC08", "Chris Jones", "USA", 30, 7, "Base", false, "Pamesa Valencia", 188);

        participantes.add(jl1);
        participantes.add(jl2);
        participantes.add(jl3);
        participantes.add(jl4);
        participantes.add(jl5);
        participantes.add(jl6);
        participantes.add(jl7);
        participantes.add(jl8);
        participantes.add(jl9);


        // Jugadores Real Madrid (VISITANTES)
        Participante jv1 = new JugadorVisitante("RMD01", "Sergio Llull", "Española", 36, 23, "Base", false, "Real Madrid", 190);
        Participante jv2 = new JugadorVisitante("RMD02", "Walter Tavares", "Cabo Verde", 31, 22, "Pívot", false, "Real Madrid", 220);
        Participante jv3 = new JugadorVisitante("RMD03", "Facundo Campazzo", "Argentina", 32, 7, "Base", false, "Real Madrid", 181);
        Participante jv4 = new JugadorVisitante("RMD04", "Rudy Fernández", "Española", 38, 5, "Alero", false, "Real Madrid", 196);
        Participante jv5 = new JugadorVisitante("RMD05", "Mario Hezonja", "Croacia", 28, 11, "Alero", false, "Real Madrid", 203);
        Participante jv6 = new JugadorVisitante("RMD06", "Dzanan Musa", "Bosnia", 24, 31, "Escolta", false, "Real Madrid", 205);
        Participante jv7 = new JugadorVisitante("RMD07", "Guerschon Yabusele", "Francia", 28, 28, "Ala-Pívot", false, "Real Madrid", 204);
        Participante jv8 = new JugadorVisitante("RMD08", "Gabriel Deck", "Argentina", 29, 14, "Alero", false, "Real Madrid", 198);

        participantes.add(jv1);
        participantes.add(jv2);
        participantes.add(jv3);
        participantes.add(jv4);
        participantes.add(jv5);
        participantes.add(jv6);
        participantes.add(jv7);
        participantes.add(jv8);

        // Árbitros
        Participante arb1 = new Arbitro("ARB01", "Juan Carlos García González", "Española", 55);
        Participante arb2 = new Arbitro("ARB02", "Antonio Conde", "Española", 51);
        Participante arb3 = new Arbitro("ARB03", "Emilio Pérez Pizarro", "Española", 53);

        participantes.add(arb1);
        participantes.add(arb2);
        participantes.add(arb3);
    }

    public static void generarListasParticipantesSeparadas(List<Participante> participantes) {
        for (Participante participante : participantes) {
            if (participante instanceof JugadorLocal) {
                jugadoresLocales.add((JugadorLocal) participante);
            } else if (participante instanceof JugadorVisitante) {
                jugadoresVisitantes.add((JugadorVisitante) participante);
            } else {
                arbitros.add((Arbitro) participante);
            }
        }
    }

    public static void generarListaParticipantesSinArbitros(List<Participante> participantes) {
        participantes.removeIf(participante -> participante instanceof Arbitro);
    }

    public static List<Jugador> getJugadoresOrdenadosEdadNacionalidad() {
        generarListaParticipantesSinArbitros(participantes);
        participantes.sort((o1, o2) -> {
            if (Integer.compare(o1.edad, o2.edad) != 0) {
                return Integer.compare(o2.edad, o1.edad);
            }
            return CharSequence.compare(o1.nacionalidad, o2.nacionalidad);
        });

        System.out.println();
        jugadoresLocales.stream().map(listaJugadores -> participantes.toString()).forEach(System.out::println);

        return null;
    }

    public static List<Jugador> getJugadoresLocalesOrdenadosAltura() {
        Comparator<JugadorLocal> comparador = new Comparator<JugadorLocal>() {
            @Override
            public int compare(JugadorLocal o1, JugadorLocal o2) { // TODO aprender que hago con el return
                return Integer.compare(o2.getAltura(), o1.getAltura());
            }
        };
        Collections.sort(jugadoresLocales, comparador);
        for (JugadorLocal listaJugadores : jugadoresLocales) {
            System.out.println(listaJugadores.toString());
        }

        return null;
    }

    //
    public static List<Jugador> getJugadoresVisitantesOrdenadosDorsal() {
        Comparator<JugadorVisitante> comparador = new Comparator<JugadorVisitante>() {
            @Override
            public int compare(JugadorVisitante o1, JugadorVisitante o2) { // TODO arreglar esto
                return Integer.compare(o2.getDorsal(), o1.getDorsal());
            }
        };
        Collections.sort(jugadoresVisitantes, comparador);
        for (JugadorVisitante listaJugadores : jugadoresVisitantes) {
            System.out.println(listaJugadores.toString());
        }
        return null;
    }

    public static List<Integer> getPuntosJugadorEnCuarto(String nombreJugador, int numeroCuarto) {
        jugar();
        if (nombreJugador == null) {
            return null;
        }
        if (numeroCuarto < 1 && numeroCuarto > 4) {
            return null;
        }
        if (numeroCuarto == 1) {
            LinkedHashMap<String, List<Integer>> anotadorTotal = primerCuarto.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                        int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                        return Integer.compare(sum2, sum1);
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
                if (entry.getKey() == nombreJugador) {
                    return entry.getValue();
                }
            }
        }
        if (numeroCuarto == 2) {
            LinkedHashMap<String, List<Integer>> anotadorTotal = segundoCuarto.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                        int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                        return Integer.compare(sum2, sum1);
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
                if (entry.getKey() == nombreJugador) {
                    return entry.getValue();
                }
            }
        }
        if (numeroCuarto == 3) {
            LinkedHashMap<String, List<Integer>> anotadorTotal = tercerCuarto.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                        int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                        return Integer.compare(sum2, sum1);
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
                if (entry.getKey() == nombreJugador) {
                    return entry.getValue();
                }
            }
        }
        if (numeroCuarto == 4) {
            LinkedHashMap<String, List<Integer>> anotadorTotal = cuartoCuarto.entrySet().stream()
                    .sorted((e1, e2) -> {
                        int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                        int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                        return Integer.compare(sum2, sum1);
                    })
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new
                    ));
            for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
                if (entry.getKey() == nombreJugador) {
                    return entry.getValue();
                }
            }
        }
        System.out.println("No ha anotado en el cuarto: "+ numeroCuarto);
        return null;
    }

    public static List<Integer> getTotalPuntoJugador(String nombreJugador) {
        jugar();
        if (nombreJugador == null) {
            return null;
        }
        LinkedHashMap<String, List<Integer>> anotadorTotal = puntuacionesJugador.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
            if(entry.getKey() == nombreJugador) {
                return entry.getValue();
            }
        }
        System.out.println("No ha anotado");
        return null;
    }

    public static List<Integer> getTotalPuntoEquipo(String equipo) {
        jugar();
        LinkedHashMap<String, List<Integer>> anotadorTotal = puntuacionesJugador.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        for (Map.Entry<String, List<Integer>> entry : anotadorTotal.entrySet()) {
            if(jugadoresLocales.get(Integer.parseInt(entry.getKey())).getEquipo().equals(equipo)) {
                return entry.getValue();
            }
        }
        System.out.println("No existe el equipo");
        return null;
    }

    public static List<Arbitro> getArbitros() {
        System.out.println();
        for (Arbitro listaArbitros : arbitros) {
            System.out.println(listaArbitros.toString());
        }
        return null;
    }

    public static void jugar() {
        System.out.println();
        Iterator<JugadorLocal> iteratorJugadorLocal = jugadoresLocales.iterator();
        Iterator<JugadorVisitante> iteratorJugadorVisitante = jugadoresVisitantes.iterator();
        List<Integer> puntosJugadoresLocales = new ArrayList<>();
        List<Integer> puntosJugadoresVisitantes = new ArrayList<>();
        List<Integer> puntosGlobal = new ArrayList<>();

        int cuarto;
        String nombreJugador;
/*

declaro, tomo el map original, lo sorteo, hago una suma con la primera entrada conviertendola en stream, luego la de la segunda entrada e2,
devuelvo una comparacion de ambas en orden descendente,
agrupo en un map defino la clave y el valor, aseguro que no hay conflictos con duplicadas,
ordeno al colector a guardarlo en un nuevo LinkedHashMap

 */

        for (int i = 0; i <= 400; i++) {
            String resultado, resultadoVisitante, resultadoArbitro;
            int posicionJugador;
            resultado = jugadoresLocales.get(random.nextInt(0, jugadoresLocales.size() - 1)).accion();
            posicionJugador = random.nextInt(0, jugadoresLocales.size() - 1);
            resultadoVisitante = jugadoresVisitantes.get(random.nextInt(0, jugadoresVisitantes.size() - 1)).accion();

            switch (resultado) {
                case "MATE", "TIRO_2_PUNTOS" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_2_PUNTOS")) {
                        puntosJugadoresLocales.add(2);
                        puntuacionesJugador.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        puntosGlobal.add(2);
                        if(i <= 100){
                            primerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        }
                    }
                }
                case "TIRO_LIBRE" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_1_PUNTO")) {
                        puntosJugadoresLocales.add(1);
                        puntosGlobal.add(1);
                        puntuacionesJugador.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        if(i <= 100){
                            primerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        }
                    }
                }
                case "TIRO_3_PUNTOS" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_3_PUNTOS")) {
                        puntosJugadoresLocales.add(3);
                        puntosGlobal.add(3);
                        puntuacionesJugador.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        if(i <= 100){
                            primerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresLocales.get(posicionJugador).nombre, puntosJugadoresLocales);
                        }
                    }
                }
                case "COMETER_FALTA" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("EXPULSION")) {
                        nombreJugador = jugadoresLocales.get(posicionJugador).nombre;
                        System.out.println("Jugador local: " + nombreJugador + " ha sido expulsado.");
                        jugadoresLocales.get(posicionJugador).setExpulsado(true);
                    }
                }
            }

            switch (resultadoVisitante) {
                case "MATE", "TIRO_2_PUNTOS" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_2_PUNTOS")) {
                        puntosJugadoresVisitantes.add(2);
                        puntosGlobal.add(2);
                        puntuacionesJugador.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        if(i <= 100){
                            primerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        }
                    }
                }
                case "TIRO_LIBRE" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_1_PUNTO")) {
                        puntosJugadoresVisitantes.add(1);
                        puntosGlobal.add(1);
                        puntuacionesJugador.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        if(i <= 100){
                            primerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        }
                    }
                }
                case "TIRO_3_PUNTOS" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("ANOTAR_3_PUNTOS")) {
                        puntosJugadoresVisitantes.add(3);
                        puntosGlobal.add(3);
                        puntuacionesJugador.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        if(i <= 100){
                            primerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 200 && i > 100){
                            segundoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 300 && i > 200){
                            tercerCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        } else if (i <= 400 && i > 300){
                            cuartoCuarto.put(jugadoresVisitantes.get(posicionJugador).nombre, puntosJugadoresVisitantes);
                        }
                    }
                }
                case "COMETER_FALTA" -> {
                    resultadoArbitro = arbitros.get(random.nextInt(0, arbitros.size() - 1)).accion();
                    if (resultadoArbitro.equals("EXPULSION")) {
                        nombreJugador = jugadoresVisitantes.get(posicionJugador).nombre;
                        System.out.println("Jugador local: " + nombreJugador + " ha sido expulsado.");
                        jugadoresVisitantes.get(posicionJugador).setExpulsado(true);
                    }
                }
            }
        }


        LinkedHashMap<String, List<Integer>> primerTiempo = primerCuarto.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        LinkedHashMap<String, List<Integer>> segundoTiempo = segundoCuarto.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        LinkedHashMap<String, List<Integer>> tercerTiempo = tercerCuarto.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        LinkedHashMap<String, List<Integer>> cuartoTiempo = cuartoCuarto.entrySet().stream()
                .sorted((e1, e2) -> {
                    int sum1 = e1.getValue().stream().mapToInt(Integer::intValue).sum();
                    int sum2 = e2.getValue().stream().mapToInt(Integer::intValue).sum();
                    return Integer.compare(sum2, sum1);
                })
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

        int puntosGlobalImprimir = 0;

        int sum = 0;
        for (int i = 0; i < puntosGlobal.size(); i++) {
            sum += puntosGlobal.get(i);
        }
        puntosGlobalImprimir = sum;

        System.out.println("DATOS DEL PARTIDO:");
        System.out.println("Equipo Local: " + jugadoresLocales.get(0).getEquipo());
        System.out.println("Equipo Visitante: " + jugadoresVisitantes.get(0).getEquipo());
        System.out.println("Puntos Global: " + puntosGlobalImprimir );
        for (Map.Entry<String, List<Integer>> entry : primerTiempo.entrySet()) {
            System.out.println("Anotadores: " + entry.getKey() + " Puntos Primer Cuarto: " + entry.getValue());
        }
        for (Map.Entry<String, List<Integer>> entry : segundoTiempo.entrySet()) {
            System.out.println("Anotadores: " + entry.getKey() + " Puntos Segundo Cuarto: " + entry.getValue());
        }
        for (Map.Entry<String, List<Integer>> entry : tercerTiempo.entrySet()) {
            System.out.println("Anotadores: " + entry.getKey() + " Puntos Tercer Cuarto: " + entry.getValue());
        }
        for (Map.Entry<String, List<Integer>> entry : cuartoTiempo.entrySet()) {
            System.out.println("Anotadores: " + entry.getKey() + " Puntos Cuarto Cuarto: " + entry.getValue());
        }
    }
}

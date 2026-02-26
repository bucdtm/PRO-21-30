package Partido;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Partido partido = new Partido();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String opcion = "";
        Scanner scanner = new Scanner(System.in);



        String menu = """
                                              
                SIMULADOR PARTIDO BALONCESTO
                ****************************
                                
                1.- Mostrar árbitros\s                
                2.- Mostrar jugadores (ordenados por edad y nacionalidad)\s
                3.- Mostrar jugadores locales (ordenados altura)\s
                4.- Mostrar jugadores visitantes (ordenados dorsal)\s
                5.- Jugar partido\s
                6.- Mostrar puntos jugador cuarto\s
                7.- Mostrar puntos jugador partido (4 cuartos)\s
                8.- Mostrar puntos equipo. Local(L) o Visitante (V)\s
                0.- Salir\s
                
                Escoge una opción: """;

        do{
            System.out.print(menu);
            opcion = scanner.nextLine();

            switch (opcion){
                case "1":
                    mostrarArbitros();
                    break;
                case "2":
                    mostrarJugadoresOrdenadosEdadNacionalidad();
                    break;
                case "3":
                    mostrarJugadoresLocalesAltura();
                    break;
                case "4":
                    mostrarJugadoresVisitantesDorsal();
                    break;
                case "5":
                    partido.jugar();
                    break;
                case "6":
                    mostrarPuntosJugadorCuarto();
                    break;
                case "7":
                    mostrarPuntosJugadorPartido();
                    break;
                case "8":
                    mostrarTotalPuntosLocalVisitante();
                    break;
                case "0":
                    System.out.println("Saliendo ....");
            }
        }while(!opcion.equals("0"));
        partido.jugar();

    }

    private static void mostrarTotalPuntosLocalVisitante() {
        System.out.println("Mostrar puntos de un equipo en el partido (Pamesa Valencia | Real Madrid   ¡¡¡ESCRITO TAL CUAL!!!)");
        String equipo = scanner.nextLine();

        Partido.getTotalPuntoEquipo(equipo);

    }

    private static void mostrarPuntosJugadorPartido() {

        System.out.println("Mostrar puntos de un jugador en el partido");
        System.out.print("Dime el nombre del jugador:");
        String nombre = scanner.nextLine();

        Partido.getTotalPuntoJugador(nombre);

        System.out.println("La puntuacion de " + nombre + " es ");
    }

    private static void mostrarPuntosJugadorCuarto() {

        System.out.println("Mostrar puntos de un jugador en un cuarto determinado");
        System.out.print("Dime el nombre del jugador:");
        String nombre = scanner.nextLine();
        System.out.print("Dime el cuarto (1/2/3/4):");
        String cuarto = scanner.nextLine();
        Partido.getPuntosJugadorEnCuarto(nombre, Integer.parseInt(cuarto));

    }

    private static void mostrarJugadoresVisitantesDorsal() {
        System.out.println("Jugadores visitantes (ordenados por dorsal)");
         Partido.getJugadoresVisitantesOrdenadosDorsal();
    }

    private static void mostrarJugadoresLocalesAltura() {
        System.out.println("Jugadores locales (ordenados por altura)");
         Partido.getJugadoresLocalesOrdenadosAltura();
    }

    private static void mostrarJugadoresOrdenadosEdadNacionalidad() {
        System.out.println("Jugadores del partido (ordenados por edad y por nacionalidad)");
         Partido.getJugadoresOrdenadosEdadNacionalidad();
    }

    private static void mostrarArbitros() {
        System.out.println("Árbitros del partido:");
        Partido.getArbitros();
    }
}
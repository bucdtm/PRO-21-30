package EjercicioProfesor;

import java.util.ArrayList;

public class ListinProfesores {
    private ArrayList<Profesor> listaProfesores;

    public ListinProfesores(){
        this.listaProfesores = new ArrayList<>();
    }
    public void addProfesor(Profesor profesor){
        listaProfesores.add(profesor);
    }
    public void listar(){
        System.out.println("=========================");
        System.out.println("== Lista de Profesores ==");
        System.out.println("=========================");
        System.out.println();
        for(Profesor profesor : listaProfesores){
            profesor.mostrarDatos();
            System.out.println();
        }
    }
}

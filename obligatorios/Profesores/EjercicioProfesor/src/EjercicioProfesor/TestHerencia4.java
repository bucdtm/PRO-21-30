package EjercicioProfesor;

import java.time.LocalDate;
import java.time.Month;

public class TestHerencia4 {
    public static void main(String[] args) {

        ListinProfesores list = new ListinProfesores();


        ProfesorInterino p1 = new ProfesorInterino("Eduardo", "Sapiña Giménez", 44,  LocalDate.of(2024, Month.FEBRUARY,13));
        p1.setIdProfesor("INT_ESG_0101");
        ProfesorTitular p2 = new ProfesorTitular("Toni", "García Tollosa", 36, LocalDate.of(2024,Month.MARCH,23));
        p2.setIdProfesor("TIT_ESG_3235");

        list.addProfesor(p1);
        list.addProfesor(p2);

        list.listar();


    }
}

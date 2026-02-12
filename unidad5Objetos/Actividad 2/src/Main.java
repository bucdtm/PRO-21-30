import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {

        ArrayList<Coche> coches = new ArrayList<>();

        Coche c1 = new Coche("Volkswagen", "T-Cross", "2015");
        Coche c2 = new Coche("Ferrari", "La Ferrari", 2016);
        Coche c3 = new Coche("Lamborghini", "Aventador", "2022");
        Coche c4 = new Coche("Citröen", "AMI", 2023);

        coches.add(c1);
        coches.add(c2);
        coches.add(c3);
        coches.add(c4);

        for (int i = 0; i < coches.size(); i++) {
            System.out.println(coches.get(i).mostrarCoche());
            System.out.println(coches.get(i).claxon());
        }


    }
}
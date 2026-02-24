package formulaPackage;

public class Main {
    public static void main(String[] args) {
        GranPremio gp = new GranPremio("Monaco");

        GranPremio.ordenarParrilla();
        GranPremio.mostrarParticipantes();
        GranPremio.simularCarrera();
        GranPremio.mostrarResultados();
    }
}
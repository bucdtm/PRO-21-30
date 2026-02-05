import java.util.Scanner;
public class Main {
    private static final double precio_patatas = 1.80;

    public static void main(String[] args) {
    double[] MandarBilletes = ArrayBilletes();
    double[] MandarMonedas = ArrayMonedas();
    MenuMaquinaExpendedora(MandarBilletes, MandarMonedas);
}
    static double[] ArrayBilletes() {
        double[] billetes = {10, 5};
        return billetes;
    } static double[] ArrayMonedas(){
        double[] monedas = {2, 1, 0.50, 0.20, 0.10, 0.05};
        return monedas;
    } static boolean ValidarDinero(double cantidad, double[] billetes, double[] monedas){
        for (double b : billetes){
            if (cantidad == b){
                return true;
            }
        } for (double m : monedas){
            if (cantidad == m){
                return true;
            }
        }
        return false;
    } static void MenuMaquinaExpendedora(double[]billetes, double[]monedas) {
        Scanner sc = new Scanner(System.in);
        String[] codigo = {"14B"};
        String input;
        boolean validar = false, ValidarDineroWhile = false;
        double ImporteTemp = 0, DineroAcumulado = 0;

            System.out.println("========================================================");
            System.out.println("                   MÁQUINA EXPENDEDORA                  ");
            System.out.println("========================================================");
            System.out.println("                   Monedas permitidas:                  ");
            for (double m : monedas) {
                System.out.printf(" %.2f €", m);
            }
            System.out.println("");
            System.out.println("========================================================");
            System.out.println("                   Billetes permitidas:                 ");
            for (double b : billetes) {
                System.out.printf(" %.2f €", b);
            }
            System.out.println();
            System.out.println("========================================================");
            System.out.printf("               14B --- Patatas Fritas %.2f €", precio_patatas);
            System.out.println();
            System.out.println("========================================================");
            System.out.println("                  SELECCIONE PRODUCTO (14B)             ");
            System.out.println("========================================================");
        while(!validar) {
            while(!ValidarDineroWhile) {
                System.out.println("Introduzca el codigo correspondiente: ");
                input = sc.nextLine();
                if (codigo[0].equals(input)) {
                    while (DineroAcumulado < precio_patatas) {
                        System.out.printf("Dinero insertado: %.2f € | Falta: %.2f €\n", DineroAcumulado, precio_patatas - DineroAcumulado);
                        System.out.println("Introduzca una moneda o billete permitido: ");
                        try {
                            ImporteTemp = sc.nextDouble();
                            sc.nextLine();

                            if (ValidarDinero(ImporteTemp, billetes, monedas)) {
                                ValidarDineroWhile = true;
                                DineroAcumulado += ImporteTemp;
                                System.out.printf("Dinero aceptado: %.2f €\n", ImporteTemp);
                            } else {
                                System.err.println("ERROR: Dinero no válido. Introduzca un billete o moneda permitido.");
                                System.out.print("Inténtelo de nuevo: ");
                            }
                        }catch(java.util.InputMismatchException e){
                            System.err.println("ERROR: Formato inválido. Debe introducir un número (ej: 10.0 o 0.50).");
                            sc.nextLine();
                            System.out.print("Inténtelo de nuevo: ");
                        }
                    }
                } else {
                    System.out.println("Te has equivocado de código, intentalo otra vez!");
                    System.out.println();
                    System.out.println("Presiona Enter para repetir el proceso: ");
                    sc.nextLine();
                    continue;
                }
            } System.out.printf("Pago completado. Su cambio es: %.2f €\n", DineroAcumulado - precio_patatas);
              validar = true;
        }
    }
}
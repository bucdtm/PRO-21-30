import java.util.ArrayList;
import java.util.Arrays;

public class PpNombreNickContrasenyaROT13 {

    // abecedario
    private static final String letras = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {

        String[] nombre = {"Eduardo", "Jose Manuel", "Carlos", "Pablo"};
        String[] apellido1 = {"Martinez", "Perez", "Lopez", "Camilo"};
        String[] apellido2 = {"Gimenez", "Romero", "Gomez", "Ambrosio"};

        // Listas de trabajo para facilitar el acceso por índice
        ArrayList<String> nombres = new ArrayList<>(Arrays.asList(nombre));
        ArrayList<String> apellidos1 = new ArrayList<>(Arrays.asList(apellido1));
        ArrayList<String> apellidos2 = new ArrayList<>(Arrays.asList(apellido2));

        // Lista para almacenar las contraseñas finales cifradas
        ArrayList<String> contrasenasROT13 = new ArrayList<>();
        ArrayList<String> nicknames = new ArrayList<>(); // Para almacenar los nicknames base

        // Bucle principal: itera por índice 1,2,3 o 0,1,2 para procesar las tres personas
        for (int i = 0; i < nombres.size(); i++) {

            // 1. Crear el Nickname
            String nicknameBase = crearNickname(nombres, apellidos1, apellidos2, i);
            nicknames.add(nicknameBase);

            // 2. Cifrar el Nickname usando ROT13 para generar la contraseña
            contrasenasROT13.add(cifraROT13(nicknameBase));
        }

        // Imprimir los resultados
        System.out.println("\nGeneración de Contraseñas ROT13 \n");
        System.out.printf("%-26s  %-12s  %s%n", " NOMBRE COMPLETO", "NICKNAME", "CONTRASEÑA");

        for (int i = 0; i < nombres.size(); i++) {
            // Se genera el nombre completo para la impresión final
            String nombreCompleto = nombres.get(i) + " " + apellidos1.get(i) + " " + apellidos2.get(i);

            System.out.printf("%-25s  %-13s  %s%n",
                    nombreCompleto,
                    nicknames.get(i),
                    contrasenasROT13.get(i)
            );
        }
    }

    // Méto.do para crear el nickname uniendo las 3 primeras letras de Nombre, Apellido1 y Apellido2, y pasándolas a minúsculas.
    public static String crearNickname(ArrayList<String> nombres, ArrayList<String> apellidos1, ArrayList<String> apellidos2, int index) {

        // Se llama a getTresLetras para obtener las 3 partes
        String parte1 = nombres.get(index).substring(0, 3);
        String parte2 = apellidos1.get(index).substring(0, 3);
        String parte3 = apellidos2.get(index).substring(0, 3);

        // Se unen las 3 partes y se convierten a minúsculas para el cifrado ROT13
        return (parte1 + parte2 + parte3).toLowerCase();
    }

    // Méto.do para obtener las 3 primeras letras de la primera palabra de una cadena (con manejo de longitud).
//    static String getTresLetras(ArrayList<String> lista, int index) {
//
//        return lista.get(index).substring(0, 3);
//
//        // Devuelve 3 letras
//
//
//   /*     if (lista.size() > index) {
//            // .split(" ")[0] obtiene la primera palabra de la frase
//            String palabra = lista.get(index).split(" ")[0];
//
//
//            // Operador ternario: Si la palabra tiene >= 3 letras, toma las 3 primeras, sino, toma la palabra entera.
//            return (palabra.length() == 3) ? palabra.substring(0, 3) : palabra;
//        }
//        return ""; // Devuelve vacío si el índice no es válido*/
//    }

    // Méto.do que implementa el cifrado ROT13.
    public static String cifraROT13(String cadena) {
        String resultado = "";
        int longitudAlfabeto = letras.length();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            int indice = letras.indexOf(caracter);

            if (indice != -1) {
                // frmular ROT13 desplazamiento de 13 posiciones con el operador módulo (%) para envolver al principio del alfabeto
                int nuevoIndice = (indice + 13) % longitudAlfabeto;
                // Concatenación de String (menos eficiente que StringBuilder, pero solicitado)
                resultado = resultado + letras.charAt(nuevoIndice);
            } else {
                // los caracteres no alfabeticos se mantienen igual
                resultado = resultado + caracter;
            }
        }
        return resultado;
    }
}
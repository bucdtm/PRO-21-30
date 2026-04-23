import java.util.Arrays;

public class BurbujaEjemplos {

    public static void main(String[] args) {
        System.out.println("--- Ejemplos de Ordenación de Burbuja en Java 18 ---\n");

        // Ejemplo 1: Burbuja Clásica (Enteros)
        int[] numeros = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("1. Array original (Clásico): " + Arrays.toString(numeros));
        burbujaClasica(numeros);
        System.out.println("   Array ordenado:           " + Arrays.toString(numeros) + "\n");

        // Ejemplo 2: Burbuja Optimizada (Enteros)
        // Usamos la inferencia de tipos 'var' disponible en versiones modernas de Java
        var numerosOpt = new int[]{5, 1, 4, 2, 8, 9};
        System.out.println("2. Array original (Optimizado): " + Arrays.toString(numerosOpt));
        burbujaOptimizada(numerosOpt);
        System.out.println("   Array ordenado:              " + Arrays.toString(numerosOpt) + "\n");

        // Ejemplo 3: Burbuja con Cadenas de Texto (Strings)
        String[] palabras = {"Zorro", "Manzana", "Pera", "Banana", "Uva"};
        System.out.println("3. Array original (Strings): " + Arrays.toString(palabras));
        burbujaStrings(palabras);
        System.out.println("   Array ordenado:           " + Arrays.toString(palabras) + "\n");
    }

    /**
     * Ejemplo 1: Implementación clásica del algoritmo de burbuja.
     * Compara elementos adyacentes y los intercambia si están en el orden incorrecto.
     */
    public static void burbujaClasica(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // El bucle interno se reduce en 'i' porque los últimos 'i' elementos ya están ordenados
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio (swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Ejemplo 2: Implementación optimizada.
     * Si en una pasada completa no se realiza ningún intercambio, significa que
     * el array ya está ordenado y podemos salir del bucle prematuramente.
     */
    public static void burbujaOptimizada(int[] arr) {
        int n = arr.length;
        boolean huboIntercambio;

        for (int i = 0; i < n - 1; i++) {
            huboIntercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    huboIntercambio = true;
                }
            }
            // Si no hubo intercambios, terminamos
            if (!huboIntercambio) {
                break;
            }
        }
    }

    /**
     * Ejemplo 3: Implementación para objetos (String).
     * En lugar de usar '>', utilizamos el método compareTo() que devuelve un
     * valor mayor a 0 si la primera cadena es alfabéticamente mayor.
     */
    public static void burbujaStrings(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Intercambio de Strings
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
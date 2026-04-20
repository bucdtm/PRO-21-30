package Ficheros5;

import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Ficheros5 {
    public static void main(String[] args) {
        try {
            String inputCount = JOptionPane.showInputDialog("Introduce la cantidad de números aleatorios:");
            String filePath = JOptionPane.showInputDialog("Introduce la ruta del fichero:");

            int count = Integer.parseInt(inputCount);
            Random random = new Random();

            try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filePath, true))) {
                for (int i = 0; i < count; i++) {
                    int randomNumber = random.nextInt(101);
                    out.writeInt(randomNumber);
                }
                out.flush();
            }

            StringBuilder output = new StringBuilder("Números en el fichero:\n");
            try (DataInputStream in = new DataInputStream(new FileInputStream(filePath))) {
                while (in.available() > 0) {
                    output.append(in.readInt()).append("\n");
                }
            }
            JOptionPane.showMessageDialog(null, output.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al introducir el número: " + e.getMessage());
        }
    }

}

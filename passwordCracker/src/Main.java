import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {

    private static final String FIXED_PREFIX = "10898158";
    private static final String CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final char[] ALPHABET = CHARS.toCharArray();

    private static final int MAX_ATTEMPTS = 1_000_000;
    private static final int PASSWORD_LENGTH = 8;
    private static final String FILE_NAME = "generated_passwords.txt";

    private static final AtomicInteger attemptCounter = new AtomicInteger(0);
    private static final AtomicBoolean stopFlag = new AtomicBoolean(false);
    private static PrintWriter fileWriter;

    public static void main(String[] args) {
        System.out.println("------------------------------------------------");
        System.out.println("Generating passwords with format: " + FIXED_PREFIX + ":password");
        System.out.println("Output File: " + FILE_NAME);
        System.out.println("------------------------------------------------");

        long start = System.currentTimeMillis();

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME)))) {
            fileWriter = pw;

            IntStream.range(0, ALPHABET.length).parallel().filter(i -> !stopFlag.get()).forEach(i -> {
                char[] buffer = new char[PASSWORD_LENGTH];
                buffer[0] = ALPHABET[i];
                generate(buffer, 1);
            });

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }

        long end = System.currentTimeMillis();
        System.out.println("Finished. Generated " + attemptCounter.get() + " lines in " + (end - start) + "ms.");
    }

    private static void generate(char[] buffer, int pos) {
        if (stopFlag.get()) return;

        if (pos == PASSWORD_LENGTH) {
            int currentCount = attemptCounter.incrementAndGet();

            if (currentCount > MAX_ATTEMPTS) {
                stopFlag.set(true);
                return;
            }

            writeToFile(new String(buffer));

            return;
        }

        for (char c : ALPHABET) {
            buffer[pos] = c;
            generate(buffer, pos + 1);
            if (stopFlag.get()) return;
        }
    }

    private static synchronized void writeToFile(String password) {
        if (fileWriter != null && !fileWriter.checkError()) {
            fileWriter.println(FIXED_PREFIX + ":" + password);
        }
    }
}
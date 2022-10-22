package FileGenerator;

import edu.princeton.cs.algs4.StdRandom;

import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.IntStream;

public class Generator {
    public static void main(String[] args) {
        String fileName = "integers.txt";
        try (FileWriter file = new FileWriter("src/resources/" + fileName)) {
            IntStream.range(0, 50).forEach(i -> {
                try {
                    file.write(StdRandom.uniform(100) + " ");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

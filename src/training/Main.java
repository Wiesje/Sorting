package training;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("src/training/words.txt");
        List<String> lines = Files.readAllLines(path);

        // Time execution of linear search
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            // Pick random word
            int randNum = new Random().nextInt(lines.size());
            String randWord = lines.get(randNum);

            //Search for word in List
            for (String line :
                    lines) {
                if (line.equals(randWord)) {
                    break;
                }
            }

        }

        long endTime = System.currentTimeMillis();

        System.out.println("Execution time of linear search: " + (endTime - startTime) + "mils");


        // Time execution of binary search
        startTime = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            // Pick random word
            int randNum = new Random().nextInt(lines.size());
            String randWord = lines.get(randNum);

            //Search for word in List
            int low = 0;
            int high = lines.size() - 1;

            while (true) {
                int mid = (high + low) / 2;
                String currentLine = lines.get(mid);

                if (currentLine.equals(randWord)) {
                    break;
                } else if (currentLine.compareTo(randWord) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Execution time of binary search: " + (endTime - startTime) + "mils");


    }
}

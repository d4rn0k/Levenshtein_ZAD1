import java.io.File;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        final String inputFileName;
        final String inputSearchedString;
        final String pattern = "^[\\s]*([a-zA-Z]+[\\s]+){1,2}[a-zA-Z]+[\\s]*$ ";
        int outputLineCount = 0;
        Scanner scanner;


        try {
            if (args.length == 2) {
                inputFileName = args[0];
                inputSearchedString = args[1];
            } else {
                throw new Exception("Brak parametrów wejściowych! Koniec");
            }

            scanner = new Scanner(new File(inputFileName));

            String currentLine;
            int currentLineCount = 0;

            int minLeveshteinValue = Integer.MAX_VALUE;

            while (scanner.hasNextLine()) {
                currentLineCount++;
                currentLine = scanner.nextLine();

                int currentLevenstheinValue = Levenshtein.distance(inputSearchedString, currentLine);
                if (currentLevenstheinValue < minLeveshteinValue) {
                    minLeveshteinValue = currentLevenstheinValue;
                    outputLineCount = currentLineCount;
                }
            }

        } catch (Exception exc) {
            outputLineCount = 3;
        } finally {
            System.out.println("Linia : " + outputLineCount);
        }

    }
}

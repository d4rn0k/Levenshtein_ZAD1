import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        final String inputFileName;
        final String inputSearchedString;

        int outputLineCount = 0;

        try {
            inputFileName = args[0];
            inputSearchedString = args[1];

            outputLineCount = getAnswer(new File(inputFileName), inputSearchedString);

        } catch (Exception exc) {
            outputLineCount = 5;
        } finally {
            System.out.println("Linia : " + outputLineCount);
        }
    }

    private static int getAnswer(File inputFile, String inputSearchedString) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);

        String currentLine;
        int currentLineCount = 0;
        int outputLineCount = 0;

        int minLeveshteinValue = Integer.MAX_VALUE;

        while (scanner.hasNextLine()) {
            currentLineCount++;
            currentLine = scanner.nextLine();

            int currentLevenstheinValue = getDistanceSum(inputSearchedString.split("\\s"),
                    currentLine.split("\\s"));
            if (currentLevenstheinValue < minLeveshteinValue) {
                minLeveshteinValue = currentLevenstheinValue;
                outputLineCount = currentLineCount;
            }
        }

        return outputLineCount;
    }

    private static int getDistanceSum(String[] leftArray, String[] rightArray) {

        int outputDistance = 0;

        for (String aLeftArray : leftArray) {

            int currentWordMin = Integer.MAX_VALUE;

            for (String aRightArray : rightArray) {

                int currentWordDistance = Levenshtein.distance(aLeftArray, aRightArray);
                if (currentWordDistance < currentWordMin) {
                    currentWordMin = currentWordDistance;
                }
            }
            outputDistance += currentWordMin;
        }

        return outputDistance;
    }

}

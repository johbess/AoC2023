import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayOne {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("./resources/dayOne/calibrationInput");
        BufferedReader br = new BufferedReader(fr);

        String line;
        ArrayList<Integer> calibrationValues = new ArrayList<>();

        while ((line = br.readLine()) != null) {

            boolean foundFirst = false;
            boolean foundLast = false;


            int start = 0;
            int end = line.length() - 1;

            Character first = null;
            Character last = null;

            while (!foundFirst || !foundLast) {

                if (!foundFirst && start < line.length()) {
                    char c = line.charAt(start);
                    if (Character.isDigit(c)) {
                        first = c;
                        foundFirst = true;
                    } else {
                        start++;
                    }
                }

                if (!foundLast && end >= 0) {
                    char c = line.charAt(end);
                    if (Character.isDigit(c)) {
                        last = c;
                        foundLast = true;
                    } else {
                        end--;
                    }
                }
            }

            int calibrationValue = Integer.parseInt(first + String.valueOf(last));
            calibrationValues.add(calibrationValue);
        }

        System.out.println(calibrationValues.stream().reduce(0, Integer::sum));
    }
}

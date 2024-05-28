import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class PhoneNumberWordGenerator {
    private static final char[][] digitMap = {
            {'0'}, {'1'}, {'A', 'B', 'C'}, {'D', 'E', 'F'},
            {'G', 'H', 'I'}, {'J', 'K', 'L'}, {'M', 'N', 'O'},
            {'P', 'Q', 'R', 'S'}, {'T', 'U', 'V'}, {'W', 'X', 'Y', 'Z'}
    };

    private static void generateWords(String prefix, String digits, Formatter formatter) {
        // Base case: no more digits to process
        if (digits.length() == 0) {
            formatter.format("%s%n", prefix);
            return;
        }

        int digit = Integer.parseInt(digits.substring(0, 1));
        for (char letter : digitMap[digit]) {
            generateWords(prefix + letter, digits.substring(1), formatter);
        }
    }

    public static void main(String[] args) {
        String phoneNumber = "4382273";

        if (phoneNumber.contains("0") || phoneNumber.contains("1")) {
            System.out.println("Phone number cannot contain digits 0 or 1.");
            return;
        }

        try {
            File outputFile = new File("output.txt");
            Formatter formatter = new Formatter(outputFile);

            generateWords("", phoneNumber, formatter);

            formatter.close();

            System.out.println("Output file created: " + outputFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found.");
        }
    }
}


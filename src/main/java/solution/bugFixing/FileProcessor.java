package solution.bugFixing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Uncomment the code and find&fix the bugs in this class.
// The code is supposed to read a given file line by line,
// split each line into words, convert each word to uppercase, and add each word to the upperCaseWords list.
public class FileProcessor {
    private List<String> upperCaseWords = new ArrayList<>();

    public void parseFile(String filename)  { // no keyword catches, removed
        String line = "";
        // Using "try with resources" - since then BufferedReader and FileReader will
        // be closed automatically regardless of whether the exception occurs
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                upperCaseWords.add(line.toUpperCase());
                // line = br.readLine();// remove, otherwise you will skip every other line
                // every time we call readLine, we go to the next line
            }
            System.out.println(upperCaseWords);
        }
        catch (IOException e) { // should be IOException; catch more specific exceptions first
            System.out.println(e);
        }
        catch (Exception e) {  // not really required here, but  no harm to catch a more general exception at the end, just in case some unknown exception occurs
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        FileProcessor fp = new FileProcessor();
        fp.parseFile("src/main/java/solution/bugFixing/file");
    }
}

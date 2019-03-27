package regex30.page1097;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class show how to use regex with quantifier.
 */
public class MetaQuantifier {

    /**
     * This method read all data(text) from this file.
     * @return - String
     */
    public String fileInner() {

        String result = null;

        try(FileReader fileReader = new FileReader(
                new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\regex30\\page1097\\MetaQuantifier.java"))) {
            char[] buffer = new char[1500];
            fileReader.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                result += buffer[i];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;

        MetaQuantifier m = new MetaQuantifier();
        String str = m.fileInner();

        // Pattern witch is used to find
        pattern = Pattern.compile("F.+?r");

        matcher = pattern.matcher(str);
        boolean result;
        while ((result = matcher.find())) {
            System.out.println("Found = " + matcher.group());
        }
    }
}

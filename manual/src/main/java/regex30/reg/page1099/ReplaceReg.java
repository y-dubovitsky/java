package regex30.reg.page1099;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class show how to use replace in reg expression.
 */
public class ReplaceReg {
    public static void main(String[] args) {

        // File path
        Path path = Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\regex30\\page1099\\ReplaceReg.java");
        File file = new File(path.toString());

        // String, where we will be replace world.
        String str = null;

        // Read from file
        try(FileReader fr = new FileReader(file)) {
            char[] buffer = new char[1500];
            fr.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                str += buffer[i];
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (str != null) {
            replace(str);
        } else {
            System.out.println("Empty file");
        }
    }

    private static void replace(String str ) {
        // This is our reg.
        Pattern pattern = Pattern.compile("file");

        // Where we search word
        Matcher math = pattern.matcher(str);

        // replace world
        str = math.replaceAll("REPLACED");

        System.out.println(str);
    }
}

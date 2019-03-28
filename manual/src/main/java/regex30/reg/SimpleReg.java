package regex30.reg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * THis example show how to use regex.
 */
public class SimpleReg {
    public static void main(String[] args) {

        // Whereof we will be read text.
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\regex30\\SimpleReg.java");

        // Empty String.
        String str = null;

        // Read file, and write into string.
        try (FileInputStream f = new FileInputStream(file)) {
            int symbol;
            while ((symbol = f.read()) != -1) {
                str += (char) symbol;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // if String not null.
        if (str != null) {

            // hello - this world, which will find in text.
            Pattern pattern = Pattern.compile("hello");

            Matcher matcher = pattern.matcher(str);

            // How many matches we find.
            int count = 0;
            while (matcher.find()) {
                count++;
            }
            System.out.println("We find " + count + " matches");
        } else {
            System.out.println("Oooops, str is empty");
        }
    }
}

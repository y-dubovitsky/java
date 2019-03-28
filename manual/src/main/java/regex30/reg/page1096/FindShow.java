package regex30.reg.page1096;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class show how to use method find in regex.
 */
public class FindShow {

    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;

        String str = "";

        int i;

        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\regex30\\page1096\\FindShow.java");
        try(InputStream is = new FileInputStream(file)) {
            while ((i = is.read()) != -1) {
                str += (char)i;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        pattern = Pattern.compile("This class show how to use method find in regex.");
        matcher = pattern.matcher(str);

        int match = 0;

        while (matcher.find()) {
            match++;
            System.out.println("Count of matches = " + match);
        }

    }
}

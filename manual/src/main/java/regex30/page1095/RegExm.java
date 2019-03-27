package regex30.page1095;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * THis class show how use regex
 */
public class RegExm {
    public static void main(String[] args) {
        Pattern pattern;
        Matcher matcher;

        // Create pattern
        pattern = Pattern.compile("Hello");

        // create matcher
        matcher = pattern.matcher("Hello from my Space");

        // Return true, if "Hello" inside the String Hello from my Space
        System.out.println(matcher.find() ? "Yeas, i`m in String" : "No");

        // Return true if Hello == Hello
        System.out.println(matcher.matches() ? " Yeas, i`m in" : "No");
    }
}

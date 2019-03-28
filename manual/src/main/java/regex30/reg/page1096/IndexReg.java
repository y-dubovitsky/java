package regex30.reg.page1096;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Example
 */
public class IndexReg {
    public static void main(String[] args) {

        // This pattern we will find
        Pattern pattern = Pattern.compile("h[^ ]+");

        Matcher matcher = pattern.matcher("hello my little friend from the past" +
                " and i say hello one more time");

        while (matcher.find()) {
            System.out.println(matcher.group() + " index = " + matcher.start());
        }
    }
}

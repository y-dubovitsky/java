package regex30.reg.page1100;

import java.util.regex.Pattern;

/**
 * This class show how to use Splitter in reg expression.
 */
public class SplitReg {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100 * Math.random(); i++) {
            stringBuilder.append(i);
        }

        // Source string.
        String str = stringBuilder.toString();

        // Before
        System.out.println(str);

        // Pattern and Matcher
        Pattern pattern = Pattern.compile("[1357]");

        // Split string
        String[] splitStr = pattern.split(str);

        // After
        for (int i = 0; i < splitStr.length; i++) {
            System.out.print(splitStr[i]);
        }
    }
}

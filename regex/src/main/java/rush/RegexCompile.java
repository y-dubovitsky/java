package rush;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * This class show how to use .compile function from regex API;
 */
public class RegexCompile {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apl", "basic", "c", "c++", "c#", "cobol", "java", "javascript", "perl");
        // starting with 'c'
        Pattern pattern = Pattern.compile("^c");
        list.stream().filter(pattern.asPredicate()).forEach(System.out::println);
    }
}

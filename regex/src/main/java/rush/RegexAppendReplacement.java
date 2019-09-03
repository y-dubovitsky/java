package rush;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * In this class show how to use .append function
 */
public class RegexAppendReplacement {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123", "234", "hello world", "ultima online", "234");
        Pattern pattern = Pattern.compile("\\d");
        // filtered list
        list = list.stream().filter(pattern.asPredicate()).collect(Collectors.toList());
        //
        list.stream().forEach(System.out::println);
        pattern = Pattern.compile("2");
        Matcher matcher = pattern.matcher(list.toString());
        // new string
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, " this is a new number ");
        }
        System.out.println(sb);
    }
}

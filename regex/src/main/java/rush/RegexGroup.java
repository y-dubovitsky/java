package rush;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple example how to use .find and .group
 */
public class RegexGroup {

    private final static List<String> list = Arrays.asList("123", "234", "hello world", "ultima online", "234");
    private final static String str = "Метод intо start() возвращает начальную позицию предыдущего найденного совпадения.";

    /**
     * Filtered list by regex
     * @param regex
     */
    private static void simpleFilter(String regex) {
        Pattern pattern = Pattern.compile(regex);
        list.stream().filter((x) -> {
            Matcher matcher = pattern.matcher(x);
            return matcher.find();
        }).forEach(System.out::println);
    }

    private static void simpleGroup(String regex) {
        Pattern pattern = Pattern.compile(regex);
        list.stream().forEach(x -> {
            Matcher matcher = pattern.matcher(x);
            while (matcher.find()) {
                // how it group?
                System.out.println(matcher.group());
            }
        });
    }

    private static void startingPosition(String regex) {
        System.out.println("Working method startingPosition");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        // how to work method find?
        while (matcher.find()) {
            System.out.println("Starting position is " + matcher.start() + " and group is " + matcher.group());
        }
    }

    public static void main(String[] args) {
        RegexGroup.simpleFilter("\\d");
        RegexGroup.simpleGroup("\\d");
        RegexGroup.startingPosition("о");
    }
}

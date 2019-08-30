package streams.operations;

import java.util.stream.Stream;

public class FilterDemo {

    private final static String word = "word";

    /**
     * Generic method
     * @param t
     * @param <T>
     */
    private static <T> void someMethod(T t) {
        System.out.println("This is final operation " + t);
    }

    public static void main(String[] args) {
        // forEach
        Stream<String> stream = Stream.of("Red", "White", "Wine", "Blue", "Like a Sea");
        stream.forEach(System.out::println);

        // filter
        stream = Stream.of("Red", "White", "Wine", "Blue", "Like a Sea");
        stream.filter(word -> {
            if (!word.equals(word)) {
                word.toUpperCase();
                return false;
            }
            return true;
        }).forEach(FilterDemo::someMethod);
    }
}

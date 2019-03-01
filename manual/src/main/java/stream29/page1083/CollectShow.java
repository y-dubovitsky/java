package stream29.page1083;

import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * How to use .collect
 */
public class CollectShow {
    public static void main(String[] args) {
        LinkedList<String> linkedList = Stream.of("String", "Str")
                .collect(() -> new LinkedList<String>(),
                        (strings, s) -> strings.add(s),
                        (strings, strings2) -> strings.addAll(strings2));
    }
}

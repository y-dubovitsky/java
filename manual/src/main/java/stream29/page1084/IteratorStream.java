package stream29.page1084;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.stream.Stream;

/**
 * Use Stream Iterator and Spliterator.
 */
public class IteratorStream {
    static Iterator<Integer> iterator = Stream.of(1,2,3,4,5,4,1,-5,0,-23,123)
            .sorted(Integer::compareTo)
            .iterator();

    public static void main(String[] args) {
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        Spliterator<Object> spliterator = Stream
                .builder()
                .add("Hello")
                .add("World")
                .add("I love yoy")
                .add("@#$@#%@#")
                .build()
                .spliterator();

        // Use spliterator
        while (spliterator.tryAdvance((n) -> System.out.println(n.toString().toUpperCase())));

        // without while cycle
        Spliterator<String> sp = Stream.of("matthey", "bob").spliterator();
        sp.forEachRemaining((n) -> System.out.println(n.toUpperCase()));
    }
}

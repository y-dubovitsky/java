package stream29.page1072;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * This class show how to use reduce method in Stream API
 */
public class ReduceShow {
    public static void main(String[] args) {
        // Create Stream
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, -5, -4);

        // User reduce
        Optional<Integer> sum = intStream.reduce((a, b) -> a + b);
        sum.ifPresent(System.out::println);

        // Use reduce with identity value
         int multiple = intStream.reduce(1, (a,b) -> a * b);

         // One more reduce
        int multi = intStream.reduce(1, (a,b) -> {
            if (b % 2 == 0) return a * b;
            else return a;
        });
    }
}

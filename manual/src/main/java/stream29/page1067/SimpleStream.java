package stream29.page1067;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * This class show how to use Stream API and basic function.
 */
public class SimpleStream {
    public static void main(String[] args) {
        // Create list
        List<Integer> list = Arrays.asList(1,2,3,4,0,-65,5,6,7,8,9);

        // Show initial list
        System.out.println(list);

        // Get Stream
        Stream<Integer> stream = list.stream();

        // Get min and max values
        Optional<Integer> min = stream.min(Integer::compareTo); // this is a final operation
        if (min.isPresent()) {
            System.out.println("Min value = " + min.get());
        } else {
            System.out.println("No such element");
        }

        Optional<Integer> max = list.stream().max(Integer::compareTo); // create new stream
        System.out.println("Max value = " + max.get());

        // Create new stream, because old stream(stream) is over.
        Stream<Integer> newStream = list.stream();
        Stream<Integer> sortedStream = newStream.sorted();
        sortedStream.forEach(System.out::println);

        // filter stream
        Stream<Integer> filterStream = sortedStream.filter((n) -> {
            int i = 10;
            return n < i;
        })
                .filter((n) -> {
                    return n > 11 ? true : false; // redundant
                });
    }
}

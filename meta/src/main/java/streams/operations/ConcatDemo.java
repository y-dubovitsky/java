package streams.operations;

import java.util.stream.Stream;

public class ConcatDemo {
    public static void main(String[] args) {
        Stream<String> people1 = Stream.of("Tom", "Bob", "Sam");
        Stream<String> people2 = Stream.of("Alice", "Kate", "Sam");

        // concat
        Stream.concat(people1, people2)
                .forEach(System.out::println);

    }
}

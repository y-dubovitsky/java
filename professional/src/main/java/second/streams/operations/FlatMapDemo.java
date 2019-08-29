package second.streams.operations;

import second.streams.operations.entity.Phone;

import java.util.stream.Stream;

public class FlatMapDemo {
    public static void main(String[] args) {
        // create stream of phone
        Stream<Phone> stream = Stream.of(
                new Phone("Nokia", 34),
                new Phone("Apple", 99),
                new Phone("Moto", 45)
        );

        // use flatMap
        stream.flatMap(
                p -> Stream.of(
                        p.getName(),
                        p.getName().toUpperCase()
                )
        ).forEach(System.out::println);

    }
}

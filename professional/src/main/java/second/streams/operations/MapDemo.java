package second.streams.operations;

import second.streams.operations.entity.Phone;

import java.util.stream.Stream;

public class MapDemo {
    public static void main(String[] args) {
        // create stream of phone
        Stream<Phone> stream = Stream.of(
                new Phone("Nokia", 34),
                new Phone("Apple", 99),
                new Phone("Moto", 45)
        );

        // convert Phone to String
        stream.map(p -> p.toString())
                .forEach(System.out::println);
    }
}

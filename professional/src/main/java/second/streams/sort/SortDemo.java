package second.streams.sort;

import second.streams.operations.entity.Phone;

import java.util.stream.Stream;

public class SortDemo {
    public static void main(String[] args) {
        // create stream of phone
        Stream<Phone> stream = Stream.of(
                new Phone("Nokia", 34),
                new Phone("Apple", 99),
                new Phone("Moto", 45)
        );

        // simple sort, used comparator like a lambda expression
        stream.sorted((x,y) -> {
                    // this is bullshit just for example
                    if (x.getName().equals(y)) return 0;
                    if (!x.getName().equals(y)) return -1;
                    return 1;
                }
        )
                .forEach(System.out::println);
    }
}

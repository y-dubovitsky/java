package streams.operations;

import java.util.stream.Stream;

public class DistinctShow {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,1,3,1,5112,51,5,1,3,2,2)
                .distinct()
                .forEach(System.out::println);
    }
}

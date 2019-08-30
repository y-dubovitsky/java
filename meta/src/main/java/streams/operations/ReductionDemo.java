package streams.operations;

import java.util.stream.Stream;

public class ReductionDemo {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 89, 90, 75, -45)
                .allMatch(x -> {
                    return x > 0;
                });
    }
}

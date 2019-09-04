package second.streams.operations;

import java.util.Random;
import java.util.stream.Stream;

public class MapStream {

    /**
     * Apply some function to Stream
     */
    private static void mapFunc() {
        Stream.iterate("First element", x -> String.valueOf(x.hashCode()))
                .map(x -> x + " random int " + new Random().nextInt())
                .forEach(System.out::println);
    }

    private static void flatMapFunc() {
        Stream<Integer> stream = Stream.iterate(15, x -> {
            return x = x + 15;
        })
                .flatMap(x -> {
                    return Stream.of(x);
                });
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        //MapStream.mapFunc();
        MapStream.flatMapFunc();
    }
}

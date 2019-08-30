package streams.operations;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Clazz {

    public void getOutput(int str) {
        System.out.println("The number is... " + str);
    }

    public void getOutput(String str) {
        System.out.println("The number is... " + str);
    }

    public static void getStaticOutput(String str) {
        System.out.println("The number is... " + str);
    }
}

/**
 * Take a while
 */
public class TakeWhileDemo {
    public static void main(String[] args) {

        Clazz clazz = new Clazz();

        IntStream stream = IntStream.of(1,2,3,4,5,0,6,7,8,-1,-2,-3);
        // this method return all values while the condition is met
        stream.sorted()
                .takeWhile(x -> x != 0)
                .forEach(clazz::getOutput);

        // repeat flatmap
        Stream.of("Red", "White", "Zwer")
                .sorted()
                .flatMap(x -> Stream.of(
                        x.concat("First arg "),
                        x.toUpperCase()
                ))
                .forEach(clazz::getOutput);
    }
}

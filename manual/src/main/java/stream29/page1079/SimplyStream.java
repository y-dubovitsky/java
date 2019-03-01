package stream29.page1079;

import java.util.HashMap;
import java.util.stream.DoubleStream;

/**
 * This class show how to use DoubleStream
 */
public class SimplyStream {

    static class Number {
        Double value;
        String name;

        Number(Double value, String name) {
            this.value = value;
            this.name = name;
        }
    }

    public static void main(String[] args) {

        // create hashMap
        HashMap<Integer, Number> map = new HashMap<>();
        map.put(1, new Number(0.1, "First"));
        map.put(2, new Number(0.2, "Second"));

        // create Stream
        DoubleStream doubleStream = map.values().stream().mapToDouble(n -> n.value);

        // sout reduce
        Double reduceResult = doubleStream.reduce(1.0, (left, right) -> left + right);
        System.out.println(reduceResult);
    }

}

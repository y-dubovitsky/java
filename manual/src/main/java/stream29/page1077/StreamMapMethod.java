package stream29.page1077;

import java.util.Arrays;
import java.util.List;

/**
 * This class show how to use map.
 */
public class StreamMapMethod {
    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {
        List<Double> list = Arrays.asList(0.0, -0.54, -0.6, -45.5, 56.0, 123.54, 43.543);
        Double reduceResult  = list.stream().map(Math::cos) // lambda replaced
                .reduce(1.0, (a,b) -> a + b);
        System.out.println(reduceResult);
    }
}

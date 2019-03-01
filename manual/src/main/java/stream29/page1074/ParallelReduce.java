package stream29.page1074;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * This class show how to use reduce with parallel stream.
 */
public class ParallelReduce {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        // add elements into list
        int i = 10;
        while (i < 100) {
            list.add(100 * Math.random());
            i++;
        }

        // create parallel stream
        Stream<Double> stream = list.parallelStream();

        // get result of reduce
        Double result = stream.reduce(1.0, (a,b) -> a * Math.cos(b),
                        (a,b) -> a * b);
        System.out.println(result);

        // create noparallel stream
        Stream<Double> noPrStream = list.stream();
        Double resultNoParallel = noPrStream.reduce(1.0, (a,b) -> a * Math.cos(b));
        System.out.println(resultNoParallel);

        // Both of result must be equals... Let`s see..
        if (result.equals(resultNoParallel)) {
            System.out.println("Yes, It`s alive! I`m jocking! Yeap, it is equals! =)");
        }
    }
}

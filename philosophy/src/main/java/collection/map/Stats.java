package collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * This class return count of random generated values;
 */
public class Stats {
    public static void main(String[] args) {
        Random random = new Random(47);
        Map<Integer, Integer> ints = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int value = random.nextInt(30);
            Integer freq = ints.get(value);
            ints.put(value, freq == null ? 1 : freq + 1);
        }
        System.out.println(ints);
    }
}

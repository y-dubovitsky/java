package first.collections.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This example show how to update values into map
 */
public class MapUpdate {

    static List<String> list = Arrays.asList(
            "Hello", "Hello", "Word",
            "Count", "Hello", "Word",
            "Count", "Hello", "Word",
            "Count"
    );

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        // this isnt work, because map is empty
//        list.stream()
//                .forEach(x -> {
//                    map.put(x, map.get(x) + 1);
//                });
        list.stream()
                .forEach(x -> {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                });
        map.compute("Hello", (x,y) -> {
            return y = y + 100000;
        });
        // foreach
        map.forEach((a,b) -> {
            System.out.println(a + " " + b);
        });
    }
}

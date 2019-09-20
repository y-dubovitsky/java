package first.collections.map;

import java.util.*;
import java.util.function.BiFunction;

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

    static <T extends String,V extends Integer> void outputMap(Map<T,V> map) {
        map.forEach((a,b) -> {
            System.out.println(a + " " + b);
        });
    }

    /**
     * Add words from list to map; Value = same count of word from list;
     */
    static <T extends String> Map<T,Integer> listToMap(List<T> list) {
        Map<T, Integer> map = new TreeMap<>();
        list.stream()
                .forEach(x -> {
                    map.put(x, map.getOrDefault(x, 0) + 1);
                });
        return map;
    }

    /**
     * this method isnt work, if map is empty
     */
    static <T extends String> void notWork(List<T> lsit) {
        Map<String, Integer> map = new TreeMap<>();
        list.stream()
                .forEach(x -> {
                    map.put(x, map.get(x) + 1);
                });
    }

    static <S, I> void mapMerge(BiFunction<? super I, ? super I, ? extends I> function, Map<S, I> map, S key, I value) {
        map.merge(key, value, function);
    }

    static <S, I> void mapCompute(BiFunction<? super String,? super Integer,? extends Integer> function, Map<String, Integer> map, String key) {
        map.compute(key, function);
    }

    /**
     * Simple factory method
     */
    static BiFunction<? super Integer, ? super Integer, ? extends Integer> getFunction(String arg) {
        BiFunction<? super Integer, ? super Integer, ? extends Integer> function = null;
        switch (arg) {
            case "first": {
                function = (x, y) -> {
                    return x.hashCode();
                };
                break;
            }
            case "second": {
                function = (x, y) -> {
                    return x + y;
                };
                break;
            }
        }
        return function;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        outputMap(map); // empty output
        map = listToMap(MapUpdate.list);
        outputMap(map);
        // merge
        MapUpdate.<String, Integer>mapMerge(getFunction("first"), map, "Hello", 4);
        outputMap(map);
        //TODO Fixed it
        // compute
        // mapCompute(getFunction("second"), map, "Spring");
        // outputMap(map);
    }
}

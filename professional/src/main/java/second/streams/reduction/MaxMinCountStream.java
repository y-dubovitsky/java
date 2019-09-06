package second.streams.reduction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class MaxMinCountStream {

    private Map<Integer, String> map = new HashMap<>();

    /**
     * Initial map when object created
     */
    public MaxMinCountStream() {
        map.put(1, "First");
        map.put(2, "Second");
        map.put(3, "Third");
    }

    protected long count(Map<Integer, String> map) {
        long result = Stream.of(map)
                .map(x -> {
                    // why this isnt work?
                    for (Map.Entry entry :x.entrySet()) {
                        System.out.println((Integer)entry.getKey() + " value " + (String)entry.getValue());
                    }
                    return x;
                })
                .count();
        return result;
    }

    protected Optional min() {
        //TODO Прочитать про Optional
        Optional<Map<Integer, String>> optional = Stream.of(map)
                .map(x -> {
                    Map<Integer, String> m = x;
                    for (Integer i = 0; i < 10; i++) {
                        m.put(i, String.valueOf(i));
                    }
                    return m;
                })
                .min(new Comparator<Map<Integer, String>>() {
                    @Override
                    public int compare(Map<Integer, String> o1, Map<Integer, String> o2) {
                        return o1.hashCode() > o2.hashCode() ? 1 : (o1.hashCode() < o2.hashCode() ? -1 : 0);
                    }
                });
        return optional;
    }

    public static void main(String[] args) {
        MaxMinCountStream s = new MaxMinCountStream();
        System.out.println(s.count(s.map));
        System.out.println(s.min());
    }

}

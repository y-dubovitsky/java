package first.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class Player {

}

public class TreeMapTest {
    public static void main(String[] args) {
        Map<Integer, Player> map = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : (o1 == o2 ? 0 : -1);
            }
        });
        map.put(1, new Player());
        map.put(2, new Player());
        // foreach
        map.forEach((id, value) -> {
            System.out.println(id + " " + value);
        });
    }
}

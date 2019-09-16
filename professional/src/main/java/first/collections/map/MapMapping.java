package first.collections.map;

import java.util.*;

class Game {
    String name;

    public Game(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class MapMapping {

    private Map<Integer, Game> map = new TreeMap<>();

    private void addValues() {
        map.put(1, new Game("Ultima Online"));
        map.put(2, new Game("Forest War"));
        map.put(3, new Game("No one live forever"));
        map.put(4, new Game("Lineage 2"));
    }

    /**
     * Output on the console all values from set
     */
    private <E> void outputMap(Set<E> set) {
        set.stream()
                .forEach(System.out::print);
    }

    /**
     * Delete all elements from set
     */
    private <E> void iteratorDelete(Set<E> set) {
        Iterator<E> iterator = set.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    private <E,V extends Game> void mapEntry(Map<E,V> map) {
        for (Map.Entry<E,V> o : map.entrySet()) {
            o.setValue((V) new Game("New Game"));
        }
    }

    public static void main(String[] args) {
        MapMapping mapMapping = new MapMapping();
        // adding elements and show
        mapMapping.addValues();
        mapMapping.outputMap(mapMapping.map.entrySet());
        // change values
        mapMapping.mapEntry(mapMapping.map);
        mapMapping.outputMap(mapMapping.map.entrySet());
        // delete all elements and output
        mapMapping.iteratorDelete(mapMapping.map.entrySet());
        mapMapping.outputMap(mapMapping.map.entrySet());
    }
}

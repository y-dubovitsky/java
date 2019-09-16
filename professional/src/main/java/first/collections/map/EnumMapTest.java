package first.collections.map;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

/**
 * Simple own class
 */
class Clazz {

    private int id;

    public Clazz(int str) {
        this.id = str;
    }
}

/**
 * Enum
 */
enum Color {

    Red(new Clazz(1)),
    Blue(new Clazz(2)),
    White(new Clazz(3)),
    Green(new Clazz(4));

    private Clazz clazz;

    Color(Clazz color) {
        this.clazz = color;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Set<Color> getSet() {
        return EnumSet.allOf(Color.class);
    }
}

/**
 * Main class
 * @param <E>
 * @param <V>
 */
public class EnumMapTest<E extends Enum<Color>, V> {

    public static void main(String[] args) {
        EnumMap<Color, String> map = new EnumMap<>(Color.class);
        System.out.println(map.size());
        map.forEach((a,b) -> {
            System.out.println(a + " " + b);
        });
    }
}

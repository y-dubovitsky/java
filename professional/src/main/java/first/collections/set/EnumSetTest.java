package first.collections.set;

import java.util.EnumSet;
import java.util.Random;
import java.util.Set;

/**
 * Enum
 */
enum Days {
    MONDAY(1),
    TUESDAY(72),
    WEDNESDAY(2),
    THURSDAY(25),
    FRIDAY(42),
    SATURDAY(552),
    SUNDAY(92);

    private int value;

    Days(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/**
 * Generic class which describes how to works with enumSet
 * @param <E>
 */
public class EnumSetTest<E extends Days> {

    Set<E> set;

    public EnumSetTest(Set<E> e) {
        this.set = e;
    }

    private void outputSet(Set<E> set) {
        set.stream()
                .map((x) -> {
                    x.setValue(new Random().nextInt());
                    return x;
                })
                .forEach((x) -> {
                    System.out.println(x + " " + x.getValue());
                });
    }

    public static void main(String[] args) {
        EnumSetTest en = new EnumSetTest(EnumSet.allOf(Days.class));
        en.outputSet(en.set);
    }
}

package collections.collections_class;

import java.util.Comparator;

/**
 * Сортировщик людей
 */
public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getAge().name().compareTo(o2.getAge().name()) > 0) {
            return 1;
        } else if (o1.getAge().name().compareTo(o2.getAge().name()) < 0) {
            return -1;
        }
        return 0;
    }
}

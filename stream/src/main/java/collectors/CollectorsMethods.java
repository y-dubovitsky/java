package collectors;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Этот класс показывает работу методов Сollectors.
 */
public class CollectorsMethods {
    /**
     * Собирвет элементы в лист
     */
    public void toList() {
        List<Integer> list = Stream.<Integer>of(1,2,3,4,5)
                .collect(Collectors.toList());
        for (int i : list) {
            System.out.print(i);
        }
    }

    /**
     * Собирает элементы в множество
     */
    public void toSet() {
        List<String> list = Arrays.asList("Hello", "a", "a", "a", "1", "1", "World!");
        Set<String> set = list.stream()
                .collect(Collectors.toSet());
        for (String s : set) {
            System.out.print(s);
        }
    }

    /**
     * toCollection​(Supplier collectionFactory)
     Собирает элементы в заданную коллекцию.
     Если нужно конкретно указать, какой List, Set или другую коллекцию мы хотим использовать, то этот метод поможет.
     */
    public void toCollection() {
        List<Integer> list = Stream.of(1,2,3,4,5)
                .collect(Collectors.toCollection(ArrayList::new));
        Queue<Integer> queue = Stream.of(1,2,3,4,5)
                .collect(Collectors.toCollection(ArrayDeque::new));
    }

    /**
     * toMap​(Function keyMapper, Function valueMapper)
     Собирает элементы в Map. Каждый элемент преобразовывается в ключ и в значение,
     основываясь на результате функций keyMapper и valueMapper соответственно.
     Если нужно вернуть тот же элемент, что и пришел, то можно передать Function.identity().
     */
    public void toMap() {
        Map<Integer, String> map = Stream.of(1,2,3,4,5)
                .collect(Collectors.toMap(i -> i * i, i -> i + " hello"));
    }

    public static void main(String[] args) {
        CollectorsMethods collectorsMethods = new CollectorsMethods();
        // toList
        collectorsMethods.toList();
        // toSet
        collectorsMethods.toSet();
    }
}

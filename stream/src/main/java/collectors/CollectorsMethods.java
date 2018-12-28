package collectors;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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

    public void toMapOne() {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Map<Integer, String> map = list.stream()
                .collect(Collectors.toMap(
                        Function.identity(), // Если требуется вернуть тот же элемент, что и пришел.
                        i -> "Say hello " + i + " times"
                ));
        map.forEach((i,j) -> {
            System.out.println("Key = " + i + " value = " + j);
        });
    }

    class MyClass {
        int a;

        MyClass(int a) {
            this.a = a;
        }
    }

    /**
     * toMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction)
     * Аналогичен первой версии метода, только в случае,
     * когда встречается два одинаковых ключа, позволяет объединить значения.
     * В данном случае, для чисел 50, 55 и 20, ключ одинаков и равен 0,
     * поэтому значения накапливаются. Для 64 и 19 аналогично.
     */
    public void toMapJoin() {
        Map<Integer, String> map4 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b)
                ));
    }
    // {0="<50>, <55>, <20>", 2="<52>", 4="<64>, <19>"}

    /**
     * toMap​(Function keyMapper, Function valueMapper, BinaryOperator mergeFunction, Supplier mapFactory)
     Всё то же, только позволяет указывать, какой именно класс Map использовать.
     */
    public void toHashMap() {
        Map<Integer, String> map5 = Stream.of(50, 55, 69, 20, 19, 52)
                .collect(Collectors.toMap(
                        i -> i % 5,
                        i -> String.format("<%d>", i),
                        (a, b) -> String.join(", ", a, b),
                        LinkedHashMap::new
                ));
        // {0=<50>, <55>, <20>, 4=<69>, <19>, 2=<52>}
        // Отличие этого примера от предыдущего в том, что теперь сохраняется порядок, благодаря LinkedHashList.
    }

    /**
     * collectingAndThen​(Collector downstream, Function finisher)
     Собирает элементы с помощью указанного коллектора, а потом применяет к полученному результату функцию.
     */
    public void collectingAndThen() {
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList));
        System.out.println(list.getClass());
        List<String> list2 = Stream.of("a", "b", "c", "d")
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Function.identity(), s -> s + s),
                        map -> map.entrySet().stream()))
                .map(e -> e.toString()) // Возвращает поток
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList));
        list2.forEach(System.out::println);
        // a=aa
        // b=bb
        // c=cc
        // d=dd
    }

    /**
     * Класс, реализует интерфейс CharSequence
     */
    class MyClassCharSequence implements CharSequence {

        /**
         * Имя
         */
        String name;

        MyClassCharSequence(String name) {
            this.name = name;
        }

        @Override
        public int length() {
            return name.length();
        }

        @Override
        public char charAt(int i) {
            return name.charAt(i);
        }

        @Override
        public CharSequence subSequence(int i, int i1) {
            return name.subSequence(i, i1);
        }
    }

    /**
     * joining​()
     joining​(CharSequence delimiter)
     joining​(CharSequence delimiter, CharSequence prefix, CharSequence suffix)
     Собирает элементы, реализующие интерфейс CharSequence, в единую строку.
     Дополнительно можно указать разделитель, а также префикс и суффикс для всей последовательности.
     */
    public void joining​() {
        String myClassCharSequence = Stream.of(new MyClassCharSequence("Hello"),
                new MyClassCharSequence("World"))
                .collect(Collectors.joining(" "));
        System.out.println(myClassCharSequence);
    }

    /**
     * summingInt​(ToIntFunction mapper)
     summingLong​(ToLongFunction mapper)
     summingDouble​(ToDoubleFunction mapper)
     Коллектор, который преобразовывает объекты в int/long/double и подсчитывает сумму.

     averagingInt​(ToIntFunction mapper)
     averagingLong​(ToLongFunction mapper)
     averagingDouble​(ToDoubleFunction mapper)
     Аналогично, но со средним значением.

     summarizingInt​(ToIntFunction mapper)
     summarizingLong​(ToLongFunction mapper)
     summarizingDouble​(ToDoubleFunction mapper)
     Аналогично, но с полной статистикой.

     Все эти методы и несколько последующих, зачастую используются в качестве
     составных коллекторов для группировки или collectingAndThen.
     В том виде, в котором они показаны на примерах используются редко.
     */
    public void averaging() {
        Double average = Stream.of("1", "2", "3", "4")
                .collect(Collectors.averagingInt((n) -> {
                    return Integer.parseInt(n);
                }));
        System.out.println(average);
        Double average1 = Stream.of(1,2,3,4,5)
                .collect(Collectors.averagingInt((n) -> { // Принимает в качестве параметра ToIntFunction
                    return n + 1;
                }));
    }

    /**
     * Возвращает количество элементов
     */
    public void counting() {
        long count = Arrays.asList(1,2,3,4,5).stream()
                .collect(Collectors.counting());
    }

    public static void main(String[] args) {
        CollectorsMethods collectorsMethods = new CollectorsMethods();
        // toList
        collectorsMethods.toList();
        // toSet
        collectorsMethods.toSet();
        //toMapOne
        collectorsMethods.toMapOne();
        // joining
        collectorsMethods.joining​();
    }
}

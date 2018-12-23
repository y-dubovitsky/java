package operators.intermediate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Промежуточные операторы
 */
public class IntermediateOperators {

    /**
     * Метод фильтрует элементы стрима по признаку
     */
    public void filter() {
        Stream.Builder<String> stream = Stream.<String>builder() // Не забывай про обобщения
                .add("String")
                .add("One More String");
        for (int i = 1000; i < 10005; i++) {
            stream.accept(String.valueOf(i)); // В чем разница между accept и add?
        }
        stream.build()
                .filter((n) -> n.length() >= 5) // Фильтруем по признаку
                .forEach(System.out::print);

    }

    /**
     * Применяет функцию к каждому элементу и затем возвращает стрим,
     * в котором элементами будут результаты функции.
     * <p>
     * map можно применять для изменения типа элементов!!! Что и делается в этом примере
     */
    public void map() {
        List<Integer> list = new ArrayList<>();
        Stream.of("1", "2", "3")
                .map((n) -> n.concat("1"))
                .mapToInt(Integer::parseInt) // а можно так Integer.parseInt(n)
                .forEach(list::add);
        for (int i : list) {
            System.out.printf("%s", i);
        }
    }

    /**
     * Преобразуем int в double
     */
    public void changeType() {
        DoubleStream doubleStream = IntStream.of(1, 2, 3, 4, 5).mapToDouble((n) -> n + 0.0);
        doubleStream.forEach(System.out::print);
        System.out.println(doubleStream.getClass().getName());
        System.out.println((IntStream.of(1, 2, 3, 4)).getClass().getName());
    }

    /**
     * Создаем стримы из разных источников
     */
    public void builder() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("i" + i);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            integers.add(i);
        }
        Stream<ArrayList<String>> stream = Stream.<ArrayList<String>>builder() // Не забывай про обобщения
                .add(list)
                //.add(integers) не работает
                .build();
        stream.forEach(System.out::print);
        Stream str = Stream.builder() // Нет обобщения!
                .add(list)
                .add(integers)
                .build();
        str.forEach(System.out::print);
    }

    /**
     * Один из самых интересных операторов.
     * Работает как map, но с одним отличием — можно преобразовать один элемент в ноль, один или множество других.
     * map - возвращает Stream!!!!!! flatMap элементы стрима!
     */
    public void flatMap() {
        System.out.println();
        Stream.of(4,3,5)
                .flatMap(x -> { // И .map - разные вещи!!
                    switch (x % 2
                            ) {
                        case 0:
                            return Stream.of(1111);
                        case 1:
                            return Stream.of(2222);
                        case 2:
                        default:
                            return Stream.of(5555);
                    }
                })
                .forEach(System.out::println);
    }

    /**
     * Метод пропускает определенное количество элементов!
     */
    public void skip() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(5, 1904);

        Map<Integer, Integer> helpingMap = new HashMap<>(); // Не хранит дубликаты
        for (int i = 0; i < 5; i++) {
            helpingMap.put(i, i);
        }
        //
        map.putAll(helpingMap); // Добавили в map другую map
        Stream<Map.Entry<Integer, Integer>> stream = map.entrySet().stream();
        stream.skip(2) // пропустил первые 2 элементы под индексами 0, 1
                .forEach(System.out::print);
    }

    /**
     * Функциональный интерфейс для примера ниже
     */
    interface Interface {
        MyClass values(MyClass mc);
    }

    /**
     * Какой то класс, реализующий компаратор
     */
    class MyClass implements Comparable<MyClass> { // В компаратор передается ссылка на тот класс, который нужно сравнивать.

        int a;

        MyClass(int a) {
            this.a = a;
        }

        @Override
        public int compareTo(MyClass o) {
            return this.a - o.a;
        }
    }

    /**
     * Сортирует элементы стрима. Причём работает этот оператор очень хитро:
     * если стрим уже помечен как отсортированный, то сортировка проводиться не будет,
     * иначе соберёт все элементы, отсортирует их и вернёт новый стрим, помеченный как отсортированный
     */
    public void sorted() {
        System.out.println();
        Interface i = (x) -> {
            x.a = 1904;
            return x;
        };
        List<MyClass> list = Stream.of(i.values(new MyClass(0)), new MyClass(1), new MyClass(-6)).collect(Collectors.toList());
        list.stream()
                .sorted()
                .forEach(System.out::print);
    }

    /**
     * Убирает повторяющиеся элементы и возвращаем стрим с уникальными элементами.
     * Как и в случае с sorted, смотрит, состоит ли уже стрим из уникальных элементов
     * и если это не так, отбирает уникальные и помечает стрим как содержащий уникальные элементы.
     */
    public void distinct() {
        List<String> list = Arrays.asList("Sr", "Sr", "Sr", "Sr", "Sr", "hello");
        list = list.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println();
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     Выполняет действие над каждым элементом стрима и при этом возвращает стрим
     с элементами исходного стрима. Служит для того, чтобы передать элемент куда-нибудь,
     не разрывая при этом цепочку операторов (вы же помните,
     что forEach — терминальный оператор и после него стрим завершается?), либо для отладки.
     */
    public void peek() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = Stream.of(1,2,3,4,5,6)
                .peek((n) -> {
                    list.add(n + 10);
                })
                .map(x -> x * x)
                .collect(Collectors.toList());
        for (int a : list) {
            System.out.print(a + " ");
        }
        System.out.println();
        for (int a : list2) {
            System.out.print(a + " ");
        }
    }

    /**
     * Преобразует примитивный стрим в объектный.
     */
    public void boxed() {
        DoubleStream.of(Math.PI, 0.1, 123.34)
                .boxed() // Разобраться как работает
                .map(Object::getClass);
    }

    public static void main(String[] args) {
        IntermediateOperators intermediateOperators = new IntermediateOperators();
        //
        intermediateOperators.filter();
        //
        System.out.print(System.lineSeparator()); // Просто так =)
        intermediateOperators.map();
        //changeType
        System.out.print(System.lineSeparator());
        intermediateOperators.changeType();
        //builder
        intermediateOperators.builder();
        //builder
        intermediateOperators.flatMap();
        //
        intermediateOperators.skip();
        //
        intermediateOperators.sorted();
        // distinct
        intermediateOperators.distinct();
        //
        intermediateOperators.peek();
    }
}

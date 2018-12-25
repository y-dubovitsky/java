package operators.terminal;

import java.util.*;
import java.util.stream.*;

/**
 * В данном файле показано применение Терминальных операторов
 */
public class TerminalOperators {
    /**
     * Мой класс
     * @param <T>
     */
    class MyClass<T> implements Comparable<MyClass<T>>{
        T t;

        MyClass(T t) {
            this.t = t;
        }

        @Override
        public int compareTo(MyClass<T> myClass) { // Знаю что это неправильно, но хоть что-то!
            if (this.t.equals(myClass.t)) {
                return 0;
            }
            return this.t.hashCode() > myClass.t.hashCode() ? 1 : - 1;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyClass)) return false;

            MyClass<?> myClass = (MyClass<?>) o;

            return t != null ? t.equals(myClass.t) : myClass.t == null;
        }

        @Override
        public int hashCode() {
            return t != null ? t.hashCode() : 0;
        }
    }

    /**
     * Выполняет некоторое действие над всеми элементами стримами.
     * void forEach​(Consumer action)
     Выполняет указанное действие для каждого элемента стрима.
     */
    public void forEach() {
        ArrayList<Integer> list = new ArrayList<>();
        Stream.of(1,2,3,4,5)
                .forEach(list::add); // равносильно этому (n) -> list.add(n)
        for(int a : list) {
            System.out.println(a);
        }
    }

    /**
     * Тоже выполняет указанное действие для каждого элемента стрима,
     * но перед этим добивается правильного порядка вхождения элементов.
     * Используется для параллельных стримов, когда нужно получить правильную последовательность элементов.
     */
    public void forEachOrdered() {
        Stream.of(1,2,3,4,5,6,7)
                .map((n) -> n * Math.random() * 100)
                .forEachOrdered(System.out::print);
    }

    /**
     * Возвращает количесвто элементов в стриме
     */
    public void count() {
        long result = Stream.iterate(2, (n) -> n * n)
                .limit(10)
                .count(); // кол-во элементов в стриме
        System.out.println("Количество элементов в стриме = " + result);
    }

    public void collect() {
        String str = Stream.of(1,2,3,4)
                .map(String::valueOf)
                .collect(Collectors.joining("-", "<", "!"));
        System.out.println(str);
    }

    /**
     * R collect​(Supplier supplier, BiConsumer accumulator, BiConsumer combiner)
     То же, что и collect(collector), только параметры разбиты для удобства.
     Если нужно быстро сделать какую-то операцию, нет нужды реализовывать интерфейс Collector,
     достаточно передать три лямбда-выражения.

     supplier должен поставлять новые объекты (контейнеры), например new ArrayList(),
     accumulator добавляет элемент в контейнер, combiner необходим для параллельных стримов и
     объединяет части стрима воедино.
     */
    public void collectt() {
        List<String> list = Stream.of("a", "b", "c", "d")
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        // list: ["a", "b", "c", "d"]
    }

    /**
     * Возвращает нетипизированный массив с элементами стрима.
     */
    public void toArray() {
        Object[] o = Stream.generate(() -> Math.random() * 100)
                .limit(10)
                .toArray(); // Переводит в массив
        for (Object a : o) {
            if (a instanceof Double) {
                System.out.println(a + " instanceof Double!");
            } else {
                System.out.println("Noooop");
            }
        }
    }

    /**
     * T reduce​(T identity, BinaryOperator accumulator)
     Ещё один полезный оператор. Позволяет преобразовать все элементы стрима в один объект.
     Например, посчитать сумму всех элементов, либо найти минимальный элемент.

     Сперва берётся объект identity и первый элемент стрима, применяется функция accumulator и identity
     становится её результатом. Затем всё продолжается для остальных элементов.
     * @return
     */
    public int reduce() {
        return Stream.of(1, 2, 3, 4, 5)
                .reduce(10, (n,v) -> n + v);
    }

    public void reduceThreeArguments() {
        Integer i = Stream.of(1,2,3,4,5)
                //      U reduce​(U identity, BiFunction accumulator, BinaryOperator combiner)
                .reduce(10, (n,v) -> n + v, (n,v) -> n * v * 100 );
        System.out.println(i);
    }

    /**
     * Optional reduce​(BinaryOperator accumulator)
     Этот метод отличается тем, что у него нет начального объекта identity.
     В качестве него служит первый элемент стрима.
     Поскольку стрим может быть пустой и тогда identity объект не присвоится,
     то результатом функции служит Optional, позволяющий обработать и эту ситуацию, вернув Optional.empty().
     */
    public void optionalReduce() {
        Optional<Integer> result = Stream.<Integer>of(1,2,3,4,5,7)
                .reduce((start, n) -> start * n);
        System.out.println(result.get());
    }

    /**
     * Optional min​(Comparator comparator)
     Optional max​(Comparator comparator)
     Поиск минимального/максимального элемента, основываясь на переданном компараторе. Внутри вызывается reduce:
     reduce((a, b) -> comparator.compare(a, b) <= 0 ? a : b));
     reduce((a, b) -> comparator.compare(a, b) >= 0 ? a : b));
     */
    public void minAndMax() {
        ArrayList<MyClass<Integer>> list = new ArrayList<>(); // Список объектов моего класса
        for (int i = 0; i < 100; i++) {
            list.add(new MyClass<>((int)(Math.random() * 100)));
        }
        // чтобы убедиться что все ТОЧНО работает, добавим вручную минимальный и максимальный элементы
        list.add(new MyClass<>(-100));
        list.add(new MyClass<>(100000));
        MyClass<Integer> min = list.stream()
                .min(MyClass::compareTo).get();
        MyClass<Integer> max = list.stream()
                .max(MyClass::compareTo).get();
        System.out.println("Минимальный элемент = " + min.t);
        System.out.println("Максимальный элемент = " + max.t);

    }

    /**
     * Возвращает первый попавшийся элемент стрима.
     * В параллельных стримах это может быть действительно любой элемент,
     * который лежал в разбитой части последовательности.
     */
    public void findAny() {
        int[] array = new int[1000];
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = i;
        }
        int any = Arrays.<Integer>stream(array)
                .parallel()
                .findAny().getAsInt();
        int anyParallel = IntStream.range(4, 65536)
                .parallel()
                .findAny()
                .getAsInt();
        // anyParallel: 32770
        System.out.println("Любой элемент = " + any + " и еще любой " + anyParallel);
    }

    /**
     * boolean allMatch​(Predicate predicate)
     Возвращает true, если все элементы стрима удовлетворяют условию predicate.
     Если встречается какой-либо элемент, для которого результат вызова функции-предиката будет false,
     то оператор перестаёт просматривать элементы и возвращает false.
     */
    public void allMatch() {
        boolean result = false;
        result = Stream.of(1,2,3,4,5,-1)
                .allMatch((x) -> x > 3);
        System.out.println("Элементы в стриме удовлетворяют условию? " + result);
    }

    /**
     * Только для примитивных стримов. Возвращает среднее арифметическое всех элементов.
     * Либо Optional.empty, если стрим пуст.
     * @return
     */
    public double average() {
        return IntStream.of(1,2,3,4,5)
                .average()
                .getAsDouble();
    }

    /**
     * Метод позволяет собрать статистику о числовой последовательности стрима,
     * а именно:
     * количество элементов, их сумму, среднее арифметическое, минимальный и максимальный элемент.
     */
    public void statistics() {
        LongSummaryStatistics stats = LongStream.range(2, 16)
                .summaryStatistics();
        System.out.format("  count: %d%n", stats.getCount());
        System.out.format("    sum: %d%n", stats.getSum());
        System.out.format("average: %.1f%n", stats.getAverage());
        System.out.format("    min: %d%n", stats.getMin());
        System.out.format("    max: %d%n", stats.getMax());
        //   count: 14
        //     sum: 119
        // average: 8,5
        //     min: 2
        //     max: 15
    }

    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        TerminalOperators terminalOperators = new TerminalOperators();
        //
        terminalOperators.forEach();
        //
        terminalOperators.forEachOrdered();
        //
        terminalOperators.count();
        // collect
        terminalOperators.collect();
        // toArray
        terminalOperators.toArray();
        // reduce
        System.out.println(terminalOperators.reduce());
        // one more reduce
        terminalOperators.reduceThreeArguments();
        // and one more reduce
        terminalOperators.optionalReduce();
        // min & max
        terminalOperators.minAndMax();
        //
        terminalOperators.findAny();
        // allMatch
        terminalOperators.allMatch();
        // average
        System.out.println("Среднее арифметическое = " + terminalOperators.average());
    }
}

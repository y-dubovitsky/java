package operators.sources;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Операторы Stream API
 */

public class StreamOperators {
    /**
     * Пустой стрим.
     */
    public void emptyStream() {
        Stream.empty()
                .forEach(System.out::println); // Нет элементов для обработки
    }

    /**
     * Стрим для перечислений
     */
    public void of() {
        Stream.of(1,2,3,4,5)
                .map((Integer n) -> { // Применяет функцию к каждому элементу
                    int result = 0;
                    for (int i = 0; i < 10; i++) {
                        result = n * i;
                    }
                    //System.out.println("Воу воу, полегче в " + result + " раз");
                    return result;
                })
                .forEach(System.out::println);
    }

    /**
     * Возвращает пустой стрим, если в качестве аргумента передан null,
     * в противном случае, возвращает стрим из одного элемента.
     */
    public void nullAble() {
        String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
        //Stream.ofNullable(str)
        //.forEach(System.out::println);
    }

    /**
     * Генерирует последовательность символов, создаваемых функцией Supplier s.
     */
    public void generate() {
        Stream.generate(() -> {
            return Math.random() * 100; // Генерируем последовательность случайных чисел
        })
                .limit(10) // ограничение 100
                .map((Double n) -> n*n) // обрабатываем значения
                .forEach(System.out::println);
    }

    /**
     * Возвращает бесконечный стрим с элементами,
     * которые образуются в результате последовательного применения функции f к итерируемому значению.
     * Первым элементом будет seed, затем f(seed), затем f(f(seed)) и так далее.
     */
    public void iterate() {
        Stream.iterate(2, a -> a + a)
                .limit(5)
                .forEach(System.out::print);
    }

    /**
     * Всё то же самое, только добавляется ещё один аргумент hasNext:
     * если он возвращает false, то стрим завершается.
     */
    public void iterateNew() {
        //Stream.iterate(2, x -> x < 25, x -> x + 6)
        //        .forEach(System.out::println);
        // 2, 8, 14, 20
    }

    /**
     * Функциональный интерфейс
     * @param <T>
     */
    interface Interface<T> {
        abstract T method(T t);
    }

    /**
     * Объединяет два стрима.
     */
    public void concat() {

        Interface<Double> i = (x) -> Math.random() * x;
        Stream<Double> s = Stream.iterate(2.0, Math::abs) // Обрати внимание на то, как объявлен стрим
                .limit(10); // Первый стрим
        Stream.concat(s, // Объединяем стримы
                Stream.of((i.method(15.0))))
                .forEach(System.out::println);
    }

    /**
     * Создаёт мутабельный(изменяемый) объект для добавления элементов в стрим
     * без использования какого-либо контейнера для этого.
     */
    public void builder() {
        Stream.Builder<String> stream = Stream.<String>builder()
                .add("0")
                .add("1"); // Создали
        for (int i = 0; i < 10; i++) {
            stream.accept("" + i);
        }
        stream.build() // Стрим собрали, все!
                .forEach(System.out::print);

        stream.add("String"); // Стрим теперь нельзя изменять, он собран! Будет выброшено исключение java.lang.IllegalStateException
        stream.build()
                .forEach(System.out::print);

    }

    /**
     * Создает стрим из диапазона 0-9
     * Есть так же:
     * LongStream.range(-10L, -5L)
     * IntStream.rangeClosed​(int startInclusive, int endInclusive)
       LongStream.range​Closed(long startInclusive, long endInclusive)
     */
    public void range() {
        IntStream.range(0,10) // Не включая 10. IntStream.rangeClosed - включая 10
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        StreamOperators streamOperators = new StreamOperators();
        //
        streamOperators.emptyStream();
        //
        streamOperators.of();
        //
        streamOperators.generate();
        //
        streamOperators.iterate();
        //
        streamOperators.concat();
        //
        streamOperators.builder();
    }
}

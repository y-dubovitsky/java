package parallel;

/**
 * Стримы бывают последовательными (sequential) и параллельными (parallel).
 * Последовательные выполняются только в текущем потоке, а вот параллельные используют общий пул ForkJoinPool.commonPool().
 * При этом элементы разбиваются (если это возможно) на несколько групп и обрабатываются в каждом потоке отдельно.
 * Затем на нужном этапе группы объединяются в одну для предоставления конечного результата.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Функциональный интерфейс
 */
interface Interface {
    abstract public String[] array();
}

/**
 * Класс, показывающий работу параллельных стримов.
 */
public class ParallelStream {
    /**
     * Чтобы получить параллельный стрим, нужно либо вызвать метод parallelStream() вместо stream(),
     * либо превратить обычный стрим в параллельный, вызвав промежуточный оператор parallel.
     */
    public void getParallelStream() {
        List<String> list = new ArrayList<>(); // Список строк.
        Interface i = new  Interface() { // Создается объект, реализующий функциональный интерфейс и присваивается i.
            @Override
            public String[] array() {
                String[] result = new String[1000];
                for (Integer i = 0; i < 1000; i++) {
                    result[i] = i.toString();
                }
                return result;
            }
        };
        Interface a = () -> { // лямбда выражение
            String[] re = new String[1000];
            for (int j = 0; j < 1000; j++) {
                re[j] = j + "J";
            }
            return re;
        };
        // Первый стрим
        Stream.of(a.array())
                .parallel() // Операции выполняются ПАРАЛЛЕЛЬНО! Смотри описание выше.
                .forEach(list::add);
        // Второй стрим
        Stream.of(i.array())
                .parallel()
                .forEach(t -> list.add(t)); // Можно упростить

        for (String q : list) {
            System.out.print(q + " ");
        }
    }

    /**
     * Это код Шрёдингера. Он может нормально выполниться и показать 1000000,
     * может выполниться и показать 869877, а может и упасть с ошибкой
     * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 332 at java.util.ArrayList.add(ArrayList.java:459).
     Поэтому разработчики настоятельно просят воздержаться от побочных эффектов в лямбдах,
     то тут, то там говоря в документации о невмешательстве (non-interference).
     */
    public void schrodinger() {
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1000000)
                .parallel() // Проблемы в этой строке
                .forEach(i -> ints.add(i));
        System.out.println(System.lineSeparator() + ints.size());
    }


    public static void main(String[] args) {
        ParallelStream parallelStream = new ParallelStream();
        // Запускаем getParallelStream
        parallelStream.getParallelStream();
        // schrodinger
        parallelStream.schrodinger();
    }
}

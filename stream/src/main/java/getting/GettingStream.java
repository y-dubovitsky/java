package getting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream — это объект для универсальной работы с данными.
 * Мы указываем, какие операции хотим провести, при этом не заботясь о деталях реализации.
 *
 * Операторы можно разделить на две группы:
 - Промежуточные (intermediate) — обрабатывают поступающие элементы и возвращают стрим.
 Промежуточных операторов в цепочке обработки элементов может быть много.
 - Терминальные (terminal) — обрабатывают элементы и завершают работу стрима,
 так что терминальный оператор в цепочке может быть только один.
 */
public class GettingStream {
    /**
     * Стрим из массива
     */
    public void gettingStream() {
        List<Integer> list = Arrays.stream(new Integer[]{1,2,3,4,5}) // Источником служит метод Arrays.stream, который из массива args делает стрим.
                .filter((n) -> { // Применяем фильтр
                    return n > 2;
                }).collect(Collectors.toList());
        for(Integer i : list) { // Перебираем список
            System.out.println(i);
        }
    }

    /**
     * Здесь уже три промежуточных оператора:
     - filter — отбирает элементы, значение которых больше 3,
     - map — прибавляет к каждой строке ххх
     - limit — ограничивает количество элементов до 10.
     Терминальный оператор forEach применяет функцию print к каждому приходящему элементу.
     */
    public void streamFromElements() {
        Stream.of("qwe", "asd", "hello", "lambda 4ever")
                .filter((x) -> x.length() > 3)
                .map((x) -> {
                    return x += "xxx";
                })
                .limit(10)
                .forEach(System.out::println);
    }

    /**
     * Ошибка во время повторного использования стрима.
     */
    public void streamException() {
        List<String> list = Arrays.asList("qw", "hello", "my friend");
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
        try {
            stream.filter(s -> s.contains("Stream API")); // Повторно использовать стрим нельзя!
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) { // Будет выброшено исключение
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        GettingStream gettingStream = new GettingStream();
        // Запускаем gettingStream
        gettingStream.gettingStream();
        // Запускаем streamFromElements
        gettingStream.streamFromElements();
        // Запускаем streamException
        gettingStream.streamException();
    }
}

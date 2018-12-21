package operators.intermediate;

import java.util.ArrayList;
import java.util.List;
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
     *
     * map можно применять для изменения типа элементов!!! Что и делается в этом примере
     */
    public void map() {
        List<Integer> list = new ArrayList<>();
        Stream.of("1","2","3")
                .map((n) -> n.concat("1"))
                .mapToInt(Integer::parseInt) // а можно так Integer.parseInt(n)
                .forEach(list::add);
        for (int i : list) {
            System.out.printf("%s" , i);
        }
    }

    public static void main(String[] args) {
        IntermediateOperators intermediateOperators = new IntermediateOperators();
        //
        intermediateOperators.filter();
        //
        System.out.print(System.lineSeparator()); // Просто так =)
        intermediateOperators.map();
    }
}

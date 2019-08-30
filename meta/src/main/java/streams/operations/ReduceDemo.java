package streams.operations;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceDemo {

    public void LeonardusPisanusNumbers() {
        Stream<Integer> stream = Stream.of(0,1,2,3);
        // Объект BinaryOperator<T> представляет функцию, которая принимает два элемента и выполняет
        // над ними некоторую операцию, возвращая результат.
        // При этом метод reduce сохраняет результат и затем опять же
        // применяет к этому результату и следующему элементу в наборе бинарную операцию.
        Optional<Integer> op = stream.reduce(new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        });
        if (op.isPresent()) System.out.println(op.get());
    }

    public void combineString() {
        // String Combine
        Stream<String> str = Stream.of("Hello", "World", "I", "love", "Boriskina");
        Optional<String> optional = str.reduce((x, y) -> {
            return x + " " + y;
        });
        System.out.println(optional.get());
    }

    public void combineString(String first) {
        System.out.println(
                Stream.of("Hello","World")
                .reduce(first, (x,y) -> {
                    return x + " " + y;
                })
        );
    }

    public static void main(String[] args) {
        ReduceDemo r = new ReduceDemo();
        r.combineString();
        r.LeonardusPisanusNumbers();
        r.combineString("Result");
    }
}

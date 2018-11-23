package main.java.lambda15.page448;

import java.util.Date;

/**
 * Обобщенный функциональный интерфейс.
 * @param <T>
 */
interface Func<T> {
    T someFunc(T t);
}

public class LambdaAsArgumentShow<T> {

    /**
     * Обобщенный параметр.
     */
    private T t;

    /**
     * Какая то функция.
     * @param func - принимает функцию функционального интерфейса.
     * @param t - аргумент.
     * @return
     */
    public T stringOp(Func<T> func, T t) {
        return func.someFunc(t);
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Func<String> func = (str) -> str + new Date().getDay();
        System.out.println(func.someFunc("Hello from "));

        LambdaAsArgumentShow lambda = new LambdaAsArgumentShow();
        lambda.t = lambda.stringOp((str) ->
            str.hashCode(), "Hello"
        );
        System.out.println(lambda.t);
    }
}

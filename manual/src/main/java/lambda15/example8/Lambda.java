package main.java.lambda15.example8;

/**
 * Обобщенный Функциональный интерфейс
 * @param <T>
 */
interface Functional<T> {
    T someFunction(T t);
}

/**
 * Класс для прогона лямбда-выражений.
 * @param <T>
 */
public class Lambda<T> {

    /**
     * Обобщенный параметр.
     */
    T t;

    /**
     * Функция реализующая функциональный интерфейс.
     * @param functional
     * @return
     */
    public T somefunction(Functional<T> functional) {
        return functional.someFunction(t);
    }

    public T showLambda(T t) {
        Lambda<String> lambda = new Lambda();
        String var;
        // можно так
        var = lambda.somefunction((n) -> {
            String str = "Hello ";
            for (int i = 0; i < 10; i++) {
                str += i;
            }
            return str;
        });
        System.out.println(var);
        // а можно и так
        Functional<String> functional = (String n) -> {
            return n + n.length();
        };
        return (T) functional;
    }

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        System.out.println(lambda.showLambda("Hello"));
    }
}

/**
 * Класс демонстрирует передачу лямбда-выраения в качестве параметра.
 */
class SendLambda<T> {

    String str;

    public T getLambda(Functional<T> functional, T t) {
        return functional.someFunction(t);
    }

    public static void main(String[] args) {
        SendLambda<String> sendLambda = new SendLambda();
        sendLambda.str = sendLambda.getLambda((t) -> {
            return t.toUpperCase();
        }, "Hello");
        System.out.println(sendLambda.str);
    }
}

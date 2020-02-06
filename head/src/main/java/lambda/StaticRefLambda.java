package lambda;

@FunctionalInterface
interface Function<R,T> {
    R changeState(T t);
}

/**
 * Simple class with static method
 */
class Clazz {

    /**
     * Return var like a String
     */
    static String clazzMethod(Integer var) {
        return String.valueOf(var);
    }

}

/**
 * Сlass with function that takes functional interface like a parameter
 */
public class StaticRefLambda {

    /**
     * This method takes functional interface like parameter
     */
    static String method(Function<String, Integer> function, int value) {
        return function.changeState(value);
    }

    public static void main(String[] args) {
        System.out.println(StaticRefLambda.method(Clazz::clazzMethod, 1904));    }
}

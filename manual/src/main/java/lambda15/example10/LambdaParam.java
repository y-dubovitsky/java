package lambda15.example10;

/**
 * Функциональный интерфес
 * @param <T>
 */
interface SimpleFunc<T> {
    abstract T getValue(T t);
}

/**
 * Класс, показывающий работу лямбда выражения с параметром.
 */
public class LambdaParam {
    public static void main(String[] args) {
        //
        SimpleFunc<Integer> simpleFunc;
        simpleFunc = (n) -> n * n;
        System.out.println(simpleFunc.getValue(5));
        //
        SimpleFunc<String> simpleString;
        simpleString = (n) -> n.toUpperCase();
        System.out.println(simpleString.getValue("hello"));
        //
        SimpleFunc<Number> simpleNumber;
        simpleNumber = (n) -> n.hashCode();
        System.out.println(simpleNumber.getValue(1904.54));
    }
}

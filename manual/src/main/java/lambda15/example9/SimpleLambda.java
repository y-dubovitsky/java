package lambda15.example9;

/**
 * Функциональный интерфейс
 */
interface Inter {
    /**
     * Абстрактный метод
     * @return
     */
    abstract int getValue();
    /**
     * Метод по умолчанию
     */
    default void sayHello() {
        System.out.println("Hello Boys");
    }
}

/**
 * Класс, показывающий реализацию лямбда-выражения.
 */
public class SimpleLambda {

    Inter inter;

    public static void main(String[] args) {
        SimpleLambda simpleLambda = new SimpleLambda();
        simpleLambda.inter = () -> 9;
        System.out.println(simpleLambda.inter.getValue());
        simpleLambda.inter = () -> (int)Math.random() * 100;
        System.out.println(simpleLambda.inter.getValue());
    }
}

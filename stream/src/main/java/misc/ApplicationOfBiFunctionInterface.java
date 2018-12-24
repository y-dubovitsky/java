package misc;

import java.util.function.BiFunction;

/**
 * Определяем свой функциональный интерфейс на основе BiFunction
 * @param <V> - первый параметр метода
 * @param <T> - второй параметр метода
 * @param <R> - тип результата
 */
interface MyBiFunction<V,T,R> { // extends BiFunction<V,T,R> { можно не писать
    R apply(V v, T t);
}

/**
 * Определяем свой класс, который будет служить
 * @param <T>
 * @param <V>
 */
class MyClass<T,V> {

    T t;
    V v;


    MyClass(T t, V v) {
        this.t = t;
        this.v = v;
    }

    public void sout() {
        System.out.println(t + " " + v);
    }
}

/**
 * Этот пример демонстрирует примение предопределенных функциональных интерфейсов!
 */
public class ApplicationOfBiFunctionInterface {
    public static void main(String[] args) {
        // Применяем свой функциональный интерфейс
        MyBiFunction<String, Integer, MyClass> my = (s, n) -> {
            return new MyClass(s, n);
        };
        MyClass myClass = my.apply("Hello", 123);
        myClass.sout();
        // Применяем уже реализованный
        BiFunction<String, Number, MyClass> bi = (s,n) -> {
            return new MyClass(s,n);
        };
        MyClass myClass1 = bi.apply("this is BiFunction Interface", 123);
        myClass1.sout();
    }
}

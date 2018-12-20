package lambda15.example19;

import java.util.function.Consumer;
import java.util.function.UnaryOperator;

class MyClass{

    String str;

    MyClass(String s) {
        this.str = s;
    }
}

public class PredefinedFunctionInterf {
    public static void main(String[] args) {
        // Унарная операция над объектом
        UnaryOperator<String> un = (String str) -> {
            return str.toUpperCase();
        };
        System.out.println(un.apply("я теперь большой мальчик"));
        // Выполняет действие над объектом, возвращает void.
        Consumer<MyClass> consumer = (n) -> {
            n.str = "234234234";
        };
        MyClass myClass = new MyClass("123");
        consumer.accept(myClass);
        System.out.println(myClass.str);
    }
}

interface Interface {
    String get();
}

class Show{
    public static void main(String[] args) {
        Interface i = () -> {
            return "hello";
        };
        System.out.println(i.getClass().getName());
        Show show = new Show();
        System.out.println(show.getClass().getName());
    }
}

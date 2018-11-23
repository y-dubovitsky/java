package main.java.lambda15.example4;

interface MyInterface<T> {
    int myFunc(T t, T i);
}

class MyClass {
    static <T extends Number> int myClassFunc(T t, T i) {
        int result = 0;
        if (t instanceof Integer) {
            result = (Integer) i + ((Integer) t);
        } else {
            System.out.println("Преобразуем t к чему то другому :");
            System.out.println("Double t = " + (Double) t);
        }
        return result;
    }
}

public class Show {

    static <T extends Number> int myShow(MyInterface<T> mi, T t, T i) {
        return mi.myFunc(t,i);
    }

    public static void main(String[] args) {
        int out;
        out = myShow(MyClass::<Integer>myClassFunc,123, 456);
        System.out.println(out);
        // Убрали <Integer> т.е. обобщили!
        out = myShow(MyClass::myClassFunc,123.05, 456.234);
        System.out.println(out);
    }
}

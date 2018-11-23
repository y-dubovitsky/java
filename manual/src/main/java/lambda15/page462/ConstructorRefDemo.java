package main.java.lambda15.page462;

interface MyFunc<T> {
    MyClass<T> func(T t);
}

class MyClass<T> {
    private T val;

    MyClass(T t) {
        val = t;
    }

    MyClass() {
        val = null;
    }

    T getVal() {
        return val;
    }
}

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyFunc<Integer> myClassCons = MyClass<Integer>::new;
        MyClass<Integer> mc = myClassCons.func(123);
        System.out.println(mc.getVal());
    }
}

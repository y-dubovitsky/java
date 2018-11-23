package main.java.lambda15.page463;

interface MyFunc<R,T> {
    R myMeth(T t);
}

// Simple Generics Class
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

class MyClass2 {
    String str;

    MyClass2(String s) { str = s; }

    MyClass2() {
        str = null;
    }

    String getStr() {
        return str;
    }
}

public class ConstructorRefDemo {
    static <R,T> R myClassFactory(MyFunc<R, T> cons, T t) {
        return cons.myMeth(t);
    }

    public static void main(String[] args) {
        MyFunc<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
        MyClass<Double> mc = myClassFactory(myClassCons, 100.0);
        System.out.println("Первый обобщенный класс MyClass -> " + mc.getVal());
        MyFunc<MyClass2,String> myClassCons2 = MyClass2::new;
        MyClass2 mc2 = myClassFactory(myClassCons2,"Дратути!");
        System.out.println("Второй необобщенный класс -> " + mc2.getStr());
    }
}

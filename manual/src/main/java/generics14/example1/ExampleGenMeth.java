package main.java.generics14.example1;

public class ExampleGenMeth {
    public <T extends A<T>, V extends T> boolean meth(T t, V v) {
        return t.a < t.b ? true : false;
    }

    public static void main(String[] args) {
        ExampleGenMeth exampleGenMeth = new ExampleGenMeth();
        A a = new A(123,456);
        A b = new A(345, 6356);
        System.out.println(exampleGenMeth.meth(a,b));
    }
}

class A<T> implements InterfaceExample {
    int a;
    int b;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }


}

interface InterfaceExample {

}

package main.java.generics14.page396;

public class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println(ob.getClass().getName());
    }
}

class GenDemo {
    public static void main(String[] args) {
        Gen<String> strOb;

        strOb = new Gen<String>("Hello");
        strOb.showType();
        System.out.println(strOb.ob);

        Gen<Double> intOb = new Gen<>(14.4);
        intOb.showType();

        // main.java.generics14.page396.Gen
        System.out.println(intOb.getClass().getName());
        System.out.println(strOb.getClass().getName());
        //
        System.out.println(intOb .getOb());
    }
}

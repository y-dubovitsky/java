package main.java.generics14.page424;

public class NonGenClassShow {
    public static void main(String[] args) {
        NonGenClassShow nonGenClassShow = new NonGenClassShow();
        GenClass<Integer> genClass = new GenClass<Integer>(123, "Class", 123);
        genClass.showClassName();
    }
}

class NonGen {
    private int anInt;
    private String name;

    NonGen(int i) {
        anInt = i;
    }

    NonGen(int i, String name) {
        this(i);
        this.name = name;
    }

    public void showClassName() {
        System.out.println(this.getClass().getName());
    }
}

class GenClass<T> extends NonGen {
    T ob;

    GenClass(int i, String name, T t) {
        super(i, name);
        ob = t;
    }
}
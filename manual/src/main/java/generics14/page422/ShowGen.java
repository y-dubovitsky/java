package main.java.generics14.page422;

public class ShowGen {
    public static void main(String[] args) {

        GenSon<Integer,MyClass> genSon = new GenSon<>(4543,new MyClass());
        System.out.println(genSon.o + " " + genSon.ob);
    }
}

class GenParent<T> {
    T ob;

    GenParent(T ob) {
        this.ob = ob;
        System.out.println("Это конструктор родителя!");
    }
}

class GenSon<T,V> extends GenParent<T> {
    V o;

    GenSon(T ob, V o) {
        super(ob);
        this.o = o;
        System.out.println("Это дочерний конструктор!");
    }
}

class MyClass {
    private String name = getClass().getName();

    @Override
    public String toString() {
        return "Мой класс " + "name='" + name + '\'';

    }
}

package main.java.generics14.page426;

public class GenClassInstanceofShow {

    static class TestClass {

    }

    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        GenOne<TestClass> genOne = new GenOne<TestClass>(testClass);
        if (genOne instanceof GenOne<?>) {
            System.out.println(genOne.getName());
        } else {
            System.out.println("Не является объектом класса GenOne!");
        }
        if (genOne instanceof GenTwo<?,?>) {
            System.out.println(genOne.getName());
        } else {
            System.out.println("Не является объектом класса GenTwo!");
        }
        //
        GenTwo<Integer,TestClass> genTwo = new GenTwo<>(123, testClass);
        if (genTwo instanceof GenOne<?>) {
            System.out.println(genTwo + " " + genTwo.getName());
        } else {
            System.out.println("Не является объектом класса GenOne");
        }
    }
}



class GenOne<T> {
    private T ob;

    GenOne(T t) {
        ob = t;
    }

    public T getObject() {
        return ob;
    }

    public String getName() {
        return this.getClass().getName();
    }

    //Переписал метод toString()!;
    @Override
    public String toString() {
        return super.toString() + " Дратути! ";
    }
}

class GenTwo<T,V> extends GenOne<T> {
    private V vob;
    private T tob;

    GenTwo(T t, V v) {
        super(t);
        vob = v;
    }
}
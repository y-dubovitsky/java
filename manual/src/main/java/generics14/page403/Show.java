package main.java.generics14.page403;

public class Show {
    public static void main(String[] args) {
        TwoGen<Integer, Example> twoGen;
        twoGen = new TwoGen(123, new Example(10));
        twoGen.sout();
        // Выводим члены класса TwoGen.
        System.out.println("Так так так.. " + twoGen.t + " " + twoGen.w.name);
    }
}

class TwoGen<T, W> {

    T t;
    W w;

    public TwoGen(T t, W w) {
        this.t = t;
        this.w = w;
    }

    public void sout() {
        System.out.println(this.getClass().getName());
    }
}

class Example {
    int a;
    String name = this.getClass().getName();

    Example(int i) {
        a = i;
    }
}
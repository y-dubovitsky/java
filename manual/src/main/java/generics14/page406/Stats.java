package main.java.generics14.page406;

public class Stats<T extends Example & Interface> {
    int a;

    T t;

    Stats(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Example example = new Example(1904);
        Stats<Example> stats = new Stats<Example>(example);
        stats.a = stats.t.a;
        System.out.println(stats.a);
        // Пытаемся создать класс, который не принадлежит к ветке Example & Interface
        //Stats<Number> stats1 = new Stats<Number>(123);
        // Не получается!
    }
}

class Example implements Interface {
    int a;
    String nameOfClass;

    Example() {
        nameOfClass = this.getClass().getName();
    }

    Example(int i) {
        this();
        a = i;
    }

    public void show() {
        System.out.println(nameOfClass + " " + a);
    }
}

interface Interface {
    public void show();
}

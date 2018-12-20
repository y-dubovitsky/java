package lambda15.example16;

import java.util.*;

class MyClass { // implements Comparable
    int a;

    public MyClass(int a) {
        this.a = a;
    }

//    @Override
//    public int compareTo(Object o) {
//        return this.a - ((MyClass) o).a;
//    }
}

public class ComparAndLambda {

    ArrayList<MyClass> list = new ArrayList<>();

    // Свой компаратор
    static int myCompare(MyClass a, MyClass b) {
        return a.a - b.a;
    }

    public static void main(String[] args) {
        ComparAndLambda comparAndLambda = new ComparAndLambda();
        for (int i = 0; i < 10 ; i++) {
            comparAndLambda.list.add(new MyClass(((int)(Math.random() * i))));
        }
        // В качестве компаратора передается статический метод, реализующий поведение компаратора.
        MyClass myClass = Collections.max(comparAndLambda.list, ComparAndLambda::myCompare);
        System.out.println(myClass.a);
    }
}

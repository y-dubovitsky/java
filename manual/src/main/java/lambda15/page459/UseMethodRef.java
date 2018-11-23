package main.java.lambda15.page459;

import java.util.ArrayList;
import java.util.Collections;

class MyClass {
    private int val;

    MyClass(int v) {
        val = v;
    }

    int getVal() {
        return val;
    }
}

public class UseMethodRef {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String[] args) {
        ArrayList<MyClass> al = new ArrayList<>();
        al.add(new MyClass(1));
        al.add(new MyClass(2));
        al.add(new MyClass(34));
        al.add(new MyClass(-54));
        al.add(new MyClass(0));

        MyClass maxVal = Collections.max(al, UseMethodRef::compareMC);
        System.out.println("Максимальное значение - " + maxVal.getVal());
    }
}

package main.java.javaLang17.page558;

class MyClass implements Comparable {
    public int a;

    MyClass(int a) {
        this.a = a;
    }


    @Override
    public int compareTo(Object o) {
        int a = 0;
        if (this.a < ((MyClass)o).a) {
            a = -1;
        }
        if (this.a > ((MyClass)o).a) {
            a = 1;
        }
        if (this.a == ((MyClass)o).a) {
            a = 0;
        }
        return a;
    }
}

public class CompareShow {
    public static void main(String[] args) {
        MyClass a = new MyClass(-4);
        MyClass b = new MyClass(0);
        System.out.println(a.compareTo(b));
    }
}

package main.java.collection18.page581;

import java.util.ArrayList;

public class ArrayListShow {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<String>();
        System.out.println("a1 size = " + a1.size());
        a1.add("A");
        a1.add("B");
        a1.add("C");
        a1.add("E");
        a1.add("F");
        a1.add("A");
        a1.add("B");
        a1.add("C");
        a1.add("E");
        a1.add("F");
        System.out.println("a1 size = " + a1.size());
        System.out.println("a1 before: " + a1);
        a1.remove("A");
        a1.remove("A");
        a1.remove(a1.size() - 1);
        System.out.println("a1 after : " + a1);
        a1.ensureCapacity(20);
        System.out.println("a1 size after ensureCapacity = " + a1.size());
        a1.trimToSize();
        System.out.println("a1 size after trimToSize = " + a1.size());
        Object objects[] = a1.toArray();
        System.out.println(objects[1]);
    }
}

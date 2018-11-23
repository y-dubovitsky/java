package main.java.collection18.page583;

import java.util.ArrayList;

public class ArrayListToArrayShow {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<String>();
        System.out.println("a1 size = " + a1.size());
        a1.add("A");
        a1.add("B");
        a1.add("C");
        a1.add("E");
        a1.add("F");
        a1.add("E");
        a1.add("F");
        //
        String strAr[] = new String[a1.size() - 1];
        strAr = a1.toArray(strAr);
        for (String a : strAr) {
            System.out.println(a);
        }
        // Object
        Object objects[] = a1.toArray();
        System.out.println("objects size = " + objects.length);
        for (Object a : objects) {
            if (a instanceof String) {
                System.out.println(a.toString());
            } else {
                System.out.println("no dubt");
            }
        }
    }
}

package main.java.collection18.page588;

import java.util.TreeSet;

public class TreeSetShow {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("12");
        treeSet.add("a");
        treeSet.add("A");
        treeSet.add("AAA");
        treeSet.add("@#$");
        System.out.println(treeSet);
        treeSet.add("0");
        treeSet.add("123");
        treeSet.add("aaaa");
        treeSet.add("!@#$!@%$");
        System.out.println(treeSet);
        System.out.println(treeSet.subSet("0", "AAA"));
    }
}

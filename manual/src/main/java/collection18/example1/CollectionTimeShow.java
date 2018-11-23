package main.java.collection18.example1;

import java.util.*;

public class CollectionTimeShow {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        long before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        System.out.println("Для добаления элементов в ArrayList понадобилось " + (System.currentTimeMillis() - before) + " миллисекунд");
        before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
        }
        System.out.println("Для добаления элементов в HashSet понадобилось " + (System.currentTimeMillis() - before) + " миллисекунд");
        before = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedHashSet.add(i);
        }
        System.out.println("Для добаления элементов в LinkedHashSet понадобилось " + (System.currentTimeMillis() - before) + " миллисекунд");
    }
}

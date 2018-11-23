package main.java.collection18.page585;

import java.util.LinkedList;

public class LinkedListShow {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        String[] string = new String[]{"a", "b","c","D","Qwerty"};
        for (String a : string) {
            linkedList.addFirst(a);
            System.out.println("First is: " + linkedList.getFirst());
            System.out.println(linkedList);
        }
        System.out.println(System.lineSeparator());
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Удаляем : " + linkedList.pollFirst());
            System.out.println(linkedList);
        }
    }
}

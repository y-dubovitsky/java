package main.java.javaLang17.page518;

import java.util.ArrayList;
import java.util.Arrays;

public class CodePointShow {
    public static void main(String[] args) {
        char[] chars = {'0', 'b', '1', '@', 'А', 'Ю'};
        boolean bool = true;
        int i = 0;
        ArrayList<Integer> codePoints = new ArrayList<>();
        do {
            codePoints.add(Character.codePointAt(chars,i));
            System.out.println(Character.codePointAt(chars, i));
            i++;
            if (i == chars.length) {
                bool = false;
            }
        } while (bool);
        System.out.println(System.lineSeparator());
        for (int k = 0; k < codePoints.size(); k++) {
            System.out.println(codePoints.get(k) + " " + Arrays.toString(Character.toChars(codePoints.get(k))));
        }
        // Константы
        System.out.println(System.lineSeparator() + Character.TYPE.getName().toUpperCase());
        // Сравнение объектов
        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean(true);
        Boolean b3 = new Boolean(false);
        Boolean b4 = b1;
        b1 = false;
        if (b1.equals(b2)) {
            System.out.println("b1 equals b2");
        } else {
            System.out.println("b1 NOT equals b2");
        }
        if (b1.equals(b3)) {
            System.out.println("b1 equals b3");
        } else {
            System.out.println("b1 NOT equals b3");
        }
        if (b1.equals(b4)) {
            System.out.println("b1 equals b4");
        } else {
            System.out.println("b1 NOT equals b4");
        }
    }
}

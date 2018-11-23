package main.java.generics14.page415;

public class GenMethDemo {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for (int i=0; i < y.length; i++) {
            return x.equals(y[i]) ? true : false;
        }
        return false;
    }

    public static void main(String[] args) {
        Integer nums[] = {1,2,3,4,5,6};
        if (isIn(2,nums)) {
            System.out.println("number 2 inside nums!");
        }
        if (isIn(7, nums)) {
            System.out.println("number y is missing!");
        }

        String strs[] = {"one", "two", "three"};
        if (isIn("one",strs)) {
            System.out.println("yeas! String \"one\\\" into strs");
        }
        if (isIn("ten",strs)) {
            System.out.println("no, String \"ten\" is missing");
        }
    }
}

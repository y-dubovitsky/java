package main.java.generics14.page417;

public class GensCons {
    private long val;

    <T extends Number> GensCons(T t) {
        val = t.longValue();
    }

    void showVal() {
        System.out.println("value: " + val);
    }
}

class ShowValue {
    public static void main(String[] args) {
        GensCons gensCons = new GensCons(123);
        gensCons.showVal();
    }
}

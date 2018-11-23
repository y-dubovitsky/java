package main.java.generics14.page418;

public class showMinMax {
    public static void main(String[] args) {
        //Integer nums[] = {234,35,234,5,234,523,54};
        MinMaxClass<Integer> minMaxClass = new MinMaxClass<Integer>(new Integer[]{123,45,123,542,523,5});
        System.out.println(minMaxClass.max());
        System.out.println(minMaxClass.min());
    }
}

class MinMaxClass<T extends Comparable<T>> implements MinMax<T> {
    T[] vals;

    MinMaxClass(T[] o) {
        vals = o;
    }

    public T min() {
        T v = vals[0];

        for(T a: vals) {
            if (a.compareTo(v) < 0) {
                v = a;
            }
        }
        return v;
    }

    public T max() {
        T v = vals[0];

        for (int i = 0; i < vals.length; i++) {
            if (v.compareTo(vals[i]) < 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

interface MinMax<T extends Comparable<T>> {
    T min();
    T max();
}

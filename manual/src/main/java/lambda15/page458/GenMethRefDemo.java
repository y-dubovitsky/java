package main.java.lambda15.page458;

interface MyFunc<T> {
    int func(T[] vals, T v);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;

        for (int i = 0; i < vals.length; i++) {
            if (vals[i] == v) count++;
        }
        return count;
    }
}

public class GenMethRefDemo {
    static <T> int myOp(MyFunc<T> f, T[] vals, T v) {
        return f.func(vals, v);
    }

    public static void main(String[] args) {
        Integer[] vals = {1, 2, 5, 4, 543, 634, 234, 65, 2, -43};
        String[] str = {"One", "Ten", "Six", "Ten", "Seven", "Two", "Three"};
        int count;

        count = myOp(MyArrayOps::countMatching,vals,4);
        System.out.println("Массив vals содержит " + count + " чисел 4");
        count = myOp(MyArrayOps::<String>countMatching, str, "Ten");
        System.out.println("Массив содержит " + count + " слов Ten");
    }
}

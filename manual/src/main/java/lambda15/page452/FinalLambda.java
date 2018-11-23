package main.java.lambda15.page452;

interface MyInterface {
    int func(int n);
}

public class FinalLambda {
    // a - это не локальная переменная.
    static int a = 10;
    public static void main(String[] args) {
        // num - это локальная переменная!
        int num = 10;

        MyInterface myInterface = (n) -> {
            int v = num + n;
            // Изменили не локальную переменную
            a++;
            System.out.println("static int a = " + a);
            return v;
        };
        System.out.println(myInterface.func(1));
        // change final num;
        //num = 14; Будет ошибка если в теле используется лямбда выражение!
        System.out.println(num);
    }
}

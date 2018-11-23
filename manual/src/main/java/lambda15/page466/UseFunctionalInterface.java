package main.java.lambda15.page466;

import java.util.function.Function;

class MyException extends Throwable {

    MyException(String name) {
        super(name);
    }
}

public class UseFunctionalInterface {
    public static void main(String[] args) {
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for (int i = 1; i < n; i++) {
                result = result * i;
            }
            return result;
        };
        System.out.println("Факториал 10 = " + factorial.apply(10));
        // Переписываем лямбда выражение под сумму чисел
        Function<Integer[], Integer> sum = (n) -> {
            int sumLocal = 0;
            try {
                for (int i = 0; i < n.length; i++) {
                    if (n[i] == 12) {
                    throw new MyException("Выпало число 12! Авария!");
                    }
                    sumLocal += n[i];
                    System.out.println("Выводим массив n = " + n[i]);
                }
            }
            catch(MyException e) {
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("Всего вам доброго! Я всегда выведусь на экран");
            }
            return sumLocal;
        };
        System.out.println("Сумма числе равна = " + sum.apply(new Integer[]{1,4,6,3,6,2,-5,3}));
    }
}

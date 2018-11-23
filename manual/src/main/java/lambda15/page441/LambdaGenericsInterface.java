package main.java.lambda15.page441;

public class LambdaGenericsInterface {
    public static void main(String[] args) {
        GenInterface<String,Integer> genInterface;
        genInterface = a -> a*a;
        System.out.println(genInterface.getClass().getName() + " " + genInterface.square(1234));
        // Переписываем функцию подругому
        genInterface = (a) -> a*a*a;
        System.out.println(genInterface.square(4));

    }
}

interface GenInterface<V, T extends Number> {
     T square(T a);
}

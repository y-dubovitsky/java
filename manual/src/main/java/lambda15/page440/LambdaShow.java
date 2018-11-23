package main.java.lambda15.page440;

public class LambdaShow {
    public static void main(String[] args) {
        FunctionalInt functionalInt;
        functionalInt = () -> "Дратути";
        System.out.println(functionalInt.getStr());
        System.out.println(functionalInt.getValue());
    }
}
/*
Абстрактный метода определяет поведение интерфейса, -> интерфейс - функциональный.
 */
interface FunctionalInt {
    String getStr();

    default int getValue() {
        return 1234;
    }
}

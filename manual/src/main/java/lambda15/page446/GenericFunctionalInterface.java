package main.java.lambda15.page446;

interface GenInterface<T> {
    T function(T t);
}

public class GenericFunctionalInterface {
    public static void main(String[] args) {
        GenInterface<String> reverse = (str) -> {
            String result = "";
            for (int i = str.length() - 1; i >= 0; i--) {
                result += str.charAt(i);
            }
            return result;
        };
        System.out.println(reverse.function("Дратути!"));
        GenInterface<Integer> reverseInt = (numbers) -> {
            Integer result = 0;
            for (int i = 0; i < 5; i++) {
                System.out.println(numbers + " " + i);
            }
            return result;
        };
        System.out.println(reverseInt.function(123));
        GenInterface<Boolean> booleanGenInterface = (bol) -> true;
        System.out.println(booleanGenInterface.function(false));

        GenInterface<Character> characterGenInterface = (charFun) -> charFun.charValue();
        System.out.println(characterGenInterface.function('4'));
    }
}

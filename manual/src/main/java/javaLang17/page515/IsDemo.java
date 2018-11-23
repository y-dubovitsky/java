package main.java.javaLang17.page515;

public class IsDemo {
    public static void main(String[] args) {
        char[] a = {'a', 'b', '5', '?', 'A', ' '};
        for (int i = 0; i < a.length; i++) {
            if (Character.isDigit(a[i]))
                System.out.println(a[i] + " - цифра");
            if (Character.isLetter(a[i]))
                System.out.println(a[i] + " - буква");
            if (Character.isWhitespace(a[i]))
                System.out.println(a[i] + " - пробел");
            if (Character.isUpperCase(a[i]))
                System.out.println(a[i] + " - прописная буква");
            if (Character.isLowerCase(a[i]))
                System.out.println(a[i] + " - строчная буква");
        }
        // constants
        System.out.println(Character.BYTES);
        System.out.println(Character.MAX_RADIX);
        System.out.println(Character.MIN_RADIX);
        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);
        System.out.println("Объект типа Class - " + Character.TYPE);
        // 2 met
        System.out.println(Character.forDigit(1, 10));
        System.out.println(Character.digit(123, 6));
    }
}

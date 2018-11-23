package main.java.string16.example3;

public class StringBufferShow {
    public static void main(String[] args) {
        // Массив символов
        char[] chars = {'3','a','1','@'};
        StringBuffer stringBuffer = new StringBuffer("Привет дорогой мой человек");
        System.out.println("Длинна = " + stringBuffer.length());
        System.out.println("Размер выделенной памяти = " + stringBuffer.capacity());
        // Добавляем еще емкость
        stringBuffer.ensureCapacity(9);
        System.out.println("Размер выделенной памяти = " + stringBuffer.capacity());
        stringBuffer.setCharAt(0, '@');
        System.out.println(stringBuffer);
        stringBuffer.getChars(0, chars.length, chars, 0);
        for (char a: chars
             ) {
            System.out.println(a);
        }
    }
}

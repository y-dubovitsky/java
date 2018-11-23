package main.java.string16.example7;

class MyClass {

}

public class ReverseShow {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("Дратути! Дорогой мой человек");
        String str = new String(sb.reverse());
        System.out.println(sb + " " + str);
        System.out.println("Емкость sb = " + sb.capacity() + " = длина + 16");
        System.out.println("Длина sb = " + sb.length());
        // replace
        StringBuffer sb1 = new StringBuffer("И еще раз ДРАТАТИ-ТИ");
        System.out.println(sb.replace(0, 20, sb1.toString()));
        System.out.println("Длина sb = " + sb.length());
        // code point
        byte[] bytes = new byte[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            bytes[i] = (byte)sb.codePointAt(i);
            System.out.println("code point[" + i + "] = " + sb.codePointAt(i));
        }
        //
        String newStr = new String(bytes);

        System.out.println(newStr);
    }
}

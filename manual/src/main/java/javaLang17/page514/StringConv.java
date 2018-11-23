package main.java.javaLang17.page514;

public class StringConv {
    public static void main(String[] args) {
        int num = 19648;
        String str = "19648";
        System.out.println(num + " в двоичной форме = " + Integer.toBinaryString(Integer.parseInt(str)));
        System.out.println(num + " в восьмеричной форме = " + Integer.toOctalString(num));
        System.out.println(num + " в шестнадцатеричной форме = " + Integer.toHexString(num));
    }
}

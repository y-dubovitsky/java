package main.java.string16.exmaple1;

public class MyReplace {
    static String one = new String("Вхождение R первого R символа R - 2");

    public static void main(String[] args) {
        String result = new String();
        while(one.indexOf("R") != -1) {
            int index = one.indexOf("R");
            char[] oneChars = one.toCharArray();
            oneChars[index] = '@';
            one = new String(oneChars);
        }
        System.out.println(one);
        substringOut();
    }

    public static void substringOut() {
        String out = one.substring(one.length() - 3);
        System.out.println(out);
    }
}

package main.java.string16.page470;

public class MakeString {
    char[] chars = {'f', 'w', 'h', 'e', 'l', 'l', 'o'};
    private String string = new String(chars);
    // byte
    byte[] bytes = {13, 0013, 13, 54, 54, 1, -6, -54, 064, 00054, 23}; // 11 штук
    // еще одна перемен. экз типа String
    String str = new String(string); //

    public static void main(String[] args) {
        MakeString makeString = new MakeString();
        System.out.println(makeString.string);
        makeString.string = new String(makeString.chars, 2,5);
        System.out.println(makeString.string);
        makeString.string = new String(makeString.bytes);
        System.out.println(makeString.string);
        //
        System.out.println(makeString.str);
        System.out.println("Длина строки str = " + makeString.str.length());
        System.out.println("Длина строки str = " + makeString.string.length());
    }
}

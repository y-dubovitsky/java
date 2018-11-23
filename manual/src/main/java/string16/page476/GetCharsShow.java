package main.java.string16.page476;

public class GetCharsShow {
    public static void main(String[] args) {
        String strStart = new String("1234567890");
        char[] chars = new char[strStart.length()];
        chars[0] = 'a';
        chars[1] = 'b';
        chars[2] = 'D';
        chars[3] = '0';
        chars[4] = '@';
        strStart.getChars(1,5, chars, 3);
        for (char a: chars
             ) {
            System.out.println(a);
        }
    }
}

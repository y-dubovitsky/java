package main.java.string16.page472;

public class StringLiterShow {
    public static void main(String[] args) {
        System.out.println("HELLO WORLD".length());
        String strRev = "";
        for (int i = "HELLO".length() - 1; i >= 0; i--) {
            strRev += "HELLO".charAt(i);
        }
        System.out.println(strRev);
    }
}

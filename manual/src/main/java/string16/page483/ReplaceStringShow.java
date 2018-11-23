package main.java.string16.page483;

public class ReplaceStringShow {
    public static void main(String[] args) {
        String org = "This is a test. This is, too.";
        String search = "is";
        String sub = "was";
        String result = new String();
        int i = 0;
        do {
            System.out.println(org);
            i = org.indexOf(search);
            if (i != -1) {
                result = org.substring(0, i);
                result += sub;
                result += org.substring(i + search.length());
                org = result;
            }
        } while (i != -1);
    }
}

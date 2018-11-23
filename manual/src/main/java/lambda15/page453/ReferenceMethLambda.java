package main.java.lambda15.page453;

interface MyInterface {
    String func(String n);
}

class MyClass {
    static String strRev(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

public class ReferenceMethLambda {
    static String stringOp(MyInterface mi, String s) {
        return mi.func(s);
    }

    public static void main(String[] args) {
        String inStr = "public static void main(String[] args)";
        String outStr = "";
        outStr = stringOp(MyClass::strRev, inStr);
        System.out.println(outStr);
    }
}

package lambda15.page455;

interface StringFunc {
    String func(String s);
}

class MyStringOps {
    String strRev(String str) {
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
}

class MethodRefDemo {
    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String in = "public static void main(String[] args) {";
        String out = "";

        MyStringOps myStringOps = new MyStringOps();
        out = stringOp(myStringOps::strRev, in);
        System.out.println(out);
    }
}


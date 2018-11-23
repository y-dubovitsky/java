package main.java.javaLang17.page556;

import static main.java.javaLang17.page556.MyClass.*;

class MyClass {
    static int a = 1;

    public static void match() {
        System.out.println(a / 0);
    }
}

public class StackTraceShow {
    public static void main(String[] args) {
        StackTraceElement ste = new StackTraceElement("MyClass", "match", "name of file", 7);
        System.out.println(ste);
        System.out.println(ste.getClassName() + " " + ste.getFileName());
        match();
    }
}

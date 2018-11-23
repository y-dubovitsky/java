package main.java.io13.page364;

import java.io.PrintWriter;

public class PWDemo {
    public static void main(String args[]) {
        PrintWriter printWriter = new PrintWriter(System.out, true);

        printWriter.println("This is String!!!");
        int i = -7;
        printWriter.println(i);
        double d = 4.5e-7;
        printWriter.println(d);
    }
}

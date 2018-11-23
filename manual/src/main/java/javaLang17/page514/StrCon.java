package main.java.javaLang17.page514;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StrCon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<>();
        int max = 0;
        String local;
        System.out.println("Введите число, \"exit\" - для выхода");
        do {
            local = br.readLine();
            str.add(local);
            max++;
        } while (!local.equals("exit") && max < 10);
        // Варианты выбора
        System.out.println("1 - двоичная форма, 2 - весьмеричная, 3 - шестнадцатиричная");
        String con;
        do {
            con = br.readLine();
        } while (con.equals("1"));
        System.out.println("Starting switch");
        switch (con) {
            case "1": {
                for (int i = 0; i < str.size(); i++) {
                    System.out.println(str.get(i) + " в двоичной форме = " + Integer.toBinaryString(Integer.parseInt(str.get(i))));
                }
            } case "2": {
                for (int i = 0; i < str.size(); i++) {
                    System.out.println(str.get(i) + " в восьмеричной форме = " + Integer.toHexString(Integer.parseInt(str.get(i))));
                }
            } case "3": {
                for (int i = 0; i < str.size(); i++) {
                    System.out.println(str.get(i) + " в шестнадцатиричой форме = " + Integer.toOctalString(Integer.parseInt(str.get(i))));
                }
            }
        }
    }
}

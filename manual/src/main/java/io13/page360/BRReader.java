package main.java.io13.page360;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BRReader {
    public static void main(String[] args) throws IOException {
        char c;
        String str;
        // Reader - абстрактный класс, а InputStreamReader - наследник этого класса и одна из реализаций.
        Reader reader = new InputStreamReader(System.in);
        if (reader instanceof InputStreamReader) {
            reader = (InputStreamReader) reader;
            System.out.println("Yeap!");
        }
        BufferedReader br = new BufferedReader(reader);
        System.out.println("Введите символ 'q' - для выхода");
        do {
            c = (char) br.read();
            System.out.println("char = " + c);
            str = br.readLine();
            System.out.println("String = " + str);
            System.out.println(c + str);
        } while (c != 'q');
    }
}

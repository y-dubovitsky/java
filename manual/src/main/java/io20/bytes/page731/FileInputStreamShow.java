package io20.bytes.page731;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamShow {

    /**
     * Метод выводит в консоль входную строку
     * @param str
     */
    public static void sout(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        int size;
        try (FileInputStream f = new FileInputStream("src/main/java/io20/page731/FileInputStreamShow.java")) {
            sout("Количество доступных байтов = " + (size = f.available()));
            int n = size/40;
            sout("Первые " + n + " байтов прочитанные из файлы");
            for (int i = 0; i < n; i++) {
                System.out.print((char)f.read());
            }
            sout("Количество доступных байтов = " + (f.available()));
            sout("Чтение следующих " + n + " байтов методом read(b[])");
            byte b[] = new byte[n]; // Размер массива равен n
            if (f.read(b) != n) { // т.е. он берет и записывает байты в массив!!
                System.err.println("Нельзя прочитать " + n + " байтов");
            }
            sout("Количество доступных байтов = " + (f.available()));
            for (int i = 0; i < b.length; i++) { // выводит массив
                System.out.print((char)b[i]);
            }
            if (f.read(b, n/2, n/2) != n/2) {
                System.err.println("Нельзя прочитать " + n/2 + " байт");
            }
            String str = new String(b, 0, b.length);
            sout("Вау, это новая строка - " + str);
            char[] array = new char[100];
            for (int i = 0; i < 100; i++) {
                array[i] = new Character('1');
            }
            String newStr = new String(array, 0, 5);
            System.out.println(newStr);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

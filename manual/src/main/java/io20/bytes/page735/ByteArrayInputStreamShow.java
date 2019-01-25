package io20.bytes.page735;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayInputStreamShow {

    private String str = "    public static void main(String[] args) {\n" +
            "        ByteArrayInputStreamShow b = new ByteArrayInputStreamShow();\n" +
            "        b.read();\n" +
            "    }";

    /**
     * Мой дурацкий метод. Читает байты из массива, записывает в файл и выводит на экран.
     */
    public void read() {
        int reset = 10; // При каком количестве циклов перевести указатель на начадл.
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        int count = 0; // количество обращений к методу fileOutputStream.write(byteArrayInputStream.read());
        try(FileOutputStream fileOutputStream = new FileOutputStream(
                new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page735\\sout.txt"))) {
            int c;
            while ((c = byteArrayInputStream.read()) != -1) {
                fileOutputStream.write((char)c); // запись в файл
                System.out.print((char)c);
                count++;
                if (count == reset) {
                    byteArrayInputStream.reset();
                    System.out.println("Reset");
                }
            }} catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("fileOutputStream.write(byteArrayInputStream.read()); " + count);
    }

    /**
     * Метод из учебника
     */
    public void readLikeInBook() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        for (int i = 0; i < 2; i++) {
            int c;
            while ((c = byteArrayInputStream.read()) != -1) {
                if (i == 0) {
                    System.out.print((char)c);
                } else {
                    System.out.print(Character.toUpperCase((char)c));
                }
            }
            System.out.println();
            byteArrayInputStream.reset();
        }
    }

    public static void main(String[] args) {
        ByteArrayInputStreamShow b = new ByteArrayInputStreamShow();
        b.read();
        b.readLikeInBook();
    }
}

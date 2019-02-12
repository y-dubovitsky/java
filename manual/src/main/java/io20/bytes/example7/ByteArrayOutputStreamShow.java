package io20.bytes.example7;

import java.io.*;

public class ByteArrayOutputStreamShow {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\bytes\\example7\\ByteArrayOutputStreamShow.java");
        try(FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            System.out.println("Размер выходного потока = " + out.size());
            System.out.println("Количество доступных символов входного потока = " + in.available());
            byte[] bytes = new byte[10]; // размерность 10 байт
            in.read(bytes); // читаем 10 байт В МАССИВ
            for (int i = 0; i < bytes.length; i++) {
                System.out.print((char)bytes[i]);
            }

            // Записываем массив В ПОТОК ВЫВОДА
            out.write(bytes);
            System.out.println("Размер выходного потока = " + out.size());

            // Записываем поток вывода в МАССИВ
            byte[] outArray = out.toByteArray();
            for (int i = 0; i < outArray.length; i++) {
                System.out.print((char)outArray[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

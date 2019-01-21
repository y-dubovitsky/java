package io20.page730;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamShow {
    public static void main(String[] args) {
        try (FileInputStream fileInputStream =
                     new FileInputStream("src/main/java/io20/page730/FileInputStreamShow.java")) {
            System.out.println("Доступно для чтения - " + fileInputStream.available());
            // Пропускаем 400 байт ...
            fileInputStream.skip(400);
            System.out.println("Доступно для чтения ПОСЛЕ SKIP - " + fileInputStream.available());
            // Пока у нас есть байты для чтения мы их выводим в консоль!
            while (fileInputStream.available() != 0) {
                System.out.print((char)fileInputStream.read());
            }
        } catch (IOException e) { // Это суперкласс для IO исключений. От него наследуются другие исключения IO.
            e.printStackTrace();
        }
    }
}

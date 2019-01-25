package io20.bytes.example1;

import java.io.File;
import java.io.IOException;

/**
 * Создает директорию и Файл по указанному пути!
 */
public class FileInputStreamShow {
    File file;
    File directory;

    FileInputStreamShow(String fileName, String directoryName) {
        file = new File(fileName);
        directory = new File(directoryName);
        // Создаем каталог
        System.out.println(directory.mkdirs() ? "Создали Директорию" : "Не получилось!");
        // Создаем Файл.
        try {
            System.out.println(file.createNewFile() ? "Создали файл" : "Не создали Файл");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileInputStreamShow fileInputStreamShow =
                new FileInputStreamShow("src/main/java/io20/example1/file.txt",
                        "src/main/java/io20/example1/Directory");
    }
}

package io20.page720;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс показывает работу класса File.
 */
public class FileShow {
    public static void main(String[] args) {
        File file = new File("src/main/java/io20/page720/test.txt"); // Относительно папки manual
        System.out.println("Name = " + file.getName());
        System.out.println("Path = " + file.getPath());
        System.out.println("Absolute Path = " + file.getAbsolutePath());
        FileShow fileShow = new FileShow();
        fileShow.show(file.canRead() ? "Да, я свободен для чтения" : "Нет, из меня нельзя читать!");
        fileShow.show(file.exists() ? "Я существую!" : "Нет, меня нет");
        fileShow.show(file.isDirectory() ? "Я - Директория" : "Я - файл");
        fileShow.show(file.canWrite() ? "Да, в меня можно записывать " : "Нет, в меня не записать");
        // Создаем каталог
        File catalog = new File("/");
        fileShow.show(catalog.isDirectory() ? "Я - Директория" : "Я - файл");
        Arrays.stream(Objects.requireNonNull(catalog.list()))
                .forEach(System.out::println);
        // Переименовываем файл
        file.renameTo(new File("src/main/java/io20/page720/test.txt"));
        // Обратно переименуем
        file.renameTo(new File("src/main/java/io20/page720/test.txt"));
        // Удаляет файл после завершения работы JVM
        //file.deleteOnExit();
        // Преобразует файл в Path
        System.out.println(file.toPath().getClass());
    }

    public void show(String str) {
        System.out.println(str);
    }
}

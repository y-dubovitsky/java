package io20.bytes.page722;

import java.io.File;

/**
 * Класс демонстрирует работу каталога.
 */
public class DirList {
    public static void main(String[] args) {
        String dir = "src/main/java";
        File file = new File(dir);
        if (file.isDirectory()) {
            for (int i = 0; i < file.list().length; i++) {
                System.out.println(file.list()[i]);
            }
        }
    }
}

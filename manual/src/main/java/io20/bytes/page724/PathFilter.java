package io20.bytes.page724;

import java.io.File;
import java.io.FileFilter;

/**
 * Класс показывает список файлов, удовлетворящих условию.
 */
public class PathFilter {
    /**
     * Выводит информацию о пути File.
     */
    public static void sout(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java");
        File[] files = file.listFiles(new FilterPathNames("i"));
        for (int i = 0; i < files.length; i++) {
            sout(files[i].getName());
            sout(files[i].isDirectory() ? "Yeap! I am a directory " : "Nop! I am not!");
        }
    }

    /**
     * Класс, отвечающий за фильтрацию списка Файлов.
     */
    static class FilterPathNames implements FileFilter {

        /**
         * С чего начинается путь к File.
         */
        String prefix;

        public FilterPathNames(String prefix) {
            this.prefix = prefix;
        }

        /**
         * Возвращает true, если путь начинается с prefix.
         */
        @Override
        public boolean accept(File pathname) {
            return pathname.getName().startsWith(this.prefix);
        }
    }
}

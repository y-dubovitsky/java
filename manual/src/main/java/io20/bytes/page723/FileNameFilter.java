package io20.bytes.page723;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

/**
 * Возвращает список файло, удовлетворящих шаблону имен.
 */
public class FileNameFilter {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java");
        if (file.isDirectory()) {
            // Фильтр filter.accept вызывается все время при такой реализации, смотри метод супер-класса.
            String[] str = file.list(new FilterName("io"));
            for (int i = 0; i < str.length; i++) {
                System.out.println(str[i]);
            }
            String[] lambdaStr = file.list((dir, name) -> {
                return name.startsWith("coll");
            });
            Arrays.stream(lambdaStr)
                    .map((value) -> value.toUpperCase())
                    .forEach(System.out::println);
        }
    }

    /**
     * Отвечает за фильтрацию файлов по имени.
     */
    static class FilterName implements FilenameFilter {
        String prefix;

        FilterName(String name) {
            this.prefix = name;
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.startsWith(prefix);
        }
    }
}

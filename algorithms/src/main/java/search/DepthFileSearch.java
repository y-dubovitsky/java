package search;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Простой поиск вглубину файлов с расширением @Extension
 */
class DepthFileSearch {

    private static final File DIRECTORY = new File("E:\\");
    private static List<String> RESULT_LIST = new ArrayList<>();
    private static String EXTENSION = ".jpg";


    public static void main(String[] args) {
        new DepthFileSearch().fileSearch(DIRECTORY, EXTENSION, RESULT_LIST);
        System.out.println(RESULT_LIST);
    }

    private void fileSearch(File file, String extension, List<String> resultList) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) { //! Директория может быть и пуста
                for (File f : files) {
                    fileSearch(f, extension, resultList); //* Рекурсия
                }
            }
        } else {
            if (file.getName().endsWith(extension)) {
                resultList.add(file.getAbsolutePath());
            }
        }
    }

}

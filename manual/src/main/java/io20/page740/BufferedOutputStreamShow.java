package io20.page740;

import java.io.*;

public class BufferedOutputStreamShow {
    private static String str = "package ru.job4j.inputoutput;\n" +
            "\n" +
            "import java.io.File;\n" +
            "import java.util.*;\n" +
            "\n" +
            "/**\n" +
            " * Class Search.\n" +
            " */\n" +
            "public class Search {\n" +
            "\n" +
            "    /**\n" +
            "     * method to return files with an appropriate extension.\n" +
            "     *\n" +
            "     * @param parent path to parent file.\n" +
            "     * @param exts   files´ extension.\n" +
            "     * @return list of files with a given extension.\n" +
            "     */\n" +
            "    public List<File> files(String parent, List<String> exts) {\n" +
            "\n" +
            "        File parentPath = new File(parent);\n" +
            "\n" +
            "        List<File> resultList = new ArrayList<>();\n" +
            "        Queue<File> filesTree = new PriorityQueue<>();\n" +
            "\n" +
            "        Collections.addAll(filesTree, parentPath.listFiles());\n" +
            "        while (!filesTree.isEmpty()) {\n" +
            "            File tempFile = filesTree.remove();\n" +
            "            if (tempFile.isDirectory()) {\n" +
            "                Collections.addAll(filesTree, tempFile.listFiles());\n" +
            "            } else {\n" +
            "                String extension = \"\";\n" +
            "                int i = tempFile.getName().lastIndexOf('.');\n" +
            "                if (i >= 0) {\n" +
            "                    extension = tempFile.getName().substring(i + 1);\n" +
            "                }\n" +
            "                if (exts.contains(extension)) {\n" +
            "                    resultList.add(tempFile);\n" +
            "                }\n" +
            "\n" +
            "            }\n" +
            "        }\n" +
            "        return resultList;\n" +
            "\n" +
            "    }\n" +
            "}";

    public static void main(String[] args) {
        int count = 0;
        int size = 1; // Размер буфера
        try(BufferedOutputStream b = new BufferedOutputStream(
                new FileOutputStream(
                        new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page740\\out.txt")),size);
            ByteArrayInputStream ar = new ByteArrayInputStream(str.getBytes())) {
            int value;
            while((value = ar.read()) != -1) {
                b.write(value);
                count++; // Количество проходов цикла
            }
            ar.reset(); // На начало переезжаем!
            b.write(str.getBytes()); // записываем сразу все!
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(count);
        }
    }
}

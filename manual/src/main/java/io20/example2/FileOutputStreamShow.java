package io20.example2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Класс дла копирования одного файла в другой. Реализован Синглетон.
 */
public class FileOutputStreamShow {

    private File file1;
    private File file2;
    private File file3;
    private static FileOutputStreamShow fileOutputStreamShow = null;

    /**
     * Создаются файлы в конструкторе
     * @param names
     */
    private FileOutputStreamShow(String[] names) {
        try {
            file1 = new File("src/main/java/" + (this.getClass().getName()).replace('.', '/') + names[0]);
            file2 = new File("src/main/java/" + (this.getClass().getName()).replace('.', '/') +  names[1]);
            file3 = new File("src/main/java/" + (this.getClass().getName()).replace('.', '/') +  names[2]);
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Синглетон. Возвращает единственный экземпляр класса.
     */
    public static synchronized FileOutputStreamShow getInstance(String[] args) {
        if (fileOutputStreamShow != null) {
            fileOutputStreamShow = new FileOutputStreamShow(args);
        }
        return fileOutputStreamShow;
    }

    /**
     * Записывает текст файла, переданного как аргумент, в файл №1 используя метод
     * fileInputStream.read() - int.
     * Используется try c ресурсами!
     * Каждый символ прочитанный методом int variable = fileInputStream.read() - представлен в виде int.
     */
    public int writeLikeInt(String path) {
        int count = 0;
        try(FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
            while (fileInputStream.available() != 0) {
                int variable = fileInputStream.read();
                //System.out.println(variable);
                //System.out.print((char)variable); Выводит текст всех входных даных в консоль!
                count++; // количество прочитанных букв!
                fileOutputStream.write(variable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Делает все то же что и прошлый метод, только записывает в файл кусками по 100 байт.
     * @return - количество кусков по 100 байт, которыми метод записывает в файл.
     */
    public int writeLikeByte(String path) {
        int count = 0;
        try(FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream(file1)) {
            byte[] bytes = new byte[100];
            while (fileInputStream.available() != 0) {
                fileInputStream.read(bytes);
                fileOutputStream.write(bytes);
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Метод удаляет файл, переданный в аргументы
     */
    public void dropFile(File file) {
        file.deleteOnExit();
    }

    public static void main(String[] args) {
        FileOutputStreamShow fileOutputStreamShow = new FileOutputStreamShow(new String[]{"1.txt","2.txt", "3.txt"});
        System.out.println(fileOutputStreamShow.writeLikeInt("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\example2\\FileOutputStreamShow.java"));
        System.out.println(fileOutputStreamShow.writeLikeByte("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\example2\\FileOutputStreamShow.java"));
    }
}

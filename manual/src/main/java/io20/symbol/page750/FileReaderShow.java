package io20.symbol.page750;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * В приведенном ниже примере программы показано, как организовать построчное чтение
 * и запись данных из файла в стндартный поток вывода. Программа
 * читает собственный исходный файл, который должен находиться в текущем катоге.
 */
public class FileReaderShow {

    private int count;
    private File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\symbol\\FileReaderShow.java");

    /**
     * Перебираем каждый байт while((c = f.read()) != -1) {
     */
    public void charOutput() {
        try(FileReader f = new FileReader(file)) {
            int c;
            while((c = f.read()) != -1) {
                System.out.print((char)c);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Количество циклов = " + count);
            count = 0; // обнулили
        }
    }

    /**
     * Используем буфер.
     * size - размер буфера.
     */
    public void arrayCharOutput(int size) {
        int countWhile = 0; // Количество вызовов цикла while!!
        int countFor = 0; // Количество вызовов цикла for
        List<Integer> list = new ArrayList<>();
        try(FileReader fileReader = new FileReader(file)) {
            char[] chars = new char[size];
            while (fileReader.read(chars) != -1) { // Записываем в массив символов
                for (int i = 0; i < chars.length; i++) {
                    System.out.print(chars[i]);
                    countFor++;
                }
                list.add(countFor); // Заносим в список количество вызовов for
                countFor = 0; // обнулелние
                countWhile++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Количество вызовов цикла while!! = " + countWhile);
            final Integer[] i = new Integer[1];
            i[0] = 0;
            list.stream()
                    .map((n) -> {
                        System.out.print(" " + i[0] + " Вызов ");
                        i[0]++;
                        return n;
                    })
                    .forEach(System.out::print);
        }
    }

    public static void main(String[] args) {
        FileReaderShow fileReaderShow = new FileReaderShow();
        fileReaderShow.arrayCharOutput(100);
    }
}

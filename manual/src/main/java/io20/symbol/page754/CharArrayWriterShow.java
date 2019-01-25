package io20.symbol.page754;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class CharArrayWriterShow {
    // Файл для вывода
    static File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\symbol\\page754\\out.txt");

    static String str = " Furthermore, the verbs are usually transitive , " +
            "though occasionally they are used intransitively with a preposition " +
            "like for, of, or about introducing the object.";

    public static void main(String[] args) {
        CharArrayWriter c = new CharArrayWriter();
        char[] buff = new char[str.length()]; // если указать размер меньше будет исключение

        str.getChars(0, str.length(), buff, 0); // Заполняет пустой массив buff!

        //Stream.of(buff).forEach(System.out::print); Выводит весь массив в конслоь
        try {
            System.out.println(c.size()); // Размер потока ДО записи
            c.write(buff); // Записывает массив В ВЫЗЫВАЮЩИЙ ПОТОК вывода!
            System.out.println(c.size()); // .. После записи в Поток
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(c.toString()); // Вывод в виде символьной строки
        char[] exit = c.toCharArray(); // Выводит данные в массив
        Stream.of(exit).forEach(System.out::print); // Выводим массив exit
        // Выводи в вайл
        try (FileWriter f = new FileWriter(file)) {
            c.writeTo(f); // записываем выходной поток в выходной поток ФАЙЛ
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Устанавливаем поток в состояние 0.
        c.reset();
        try {
            for (int i = 0; i < 10; i++) {
                c.write("Хой");
            }
            char[] chars = c.toCharArray();
            Stream.of(chars).forEach(System.out::print);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
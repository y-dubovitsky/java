package io20.symbol.page753;

import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Кacc CharArayReader
 * Касс CharArrayReader реаизует поток вывода, использующий массив в кчестве источник данны.
 */
public class CharArrayReaderShow {
    /**
     * Поля класса.
     */
    String str = "\"C:\\Program Files\\Java\\jdk-11.0.1\\bin\\java.exe\" \"-javaagen" +
            "t:C:\\Program Files\\JetBrains\\IntelliJ IDEA 2018.3.2\\lib\\idea_rt.jar" +
            "=61541:C:\\Program Files\\JetBrains\\IntelliJ IDEA 2018.3.2\\bin\" -Dfile.enc" +
            "oding=UTF-8 -classpath C:\\Users\\user\\IdeaProjects\\java\\manual\\target\\cla" +
            "sses io20.symbol.page752.FileWriterShow\n";

    public void showRead() {
        int count = 0;
        // массив символов
        char[] chars = str.toCharArray();
        try(CharArrayReader c = new CharArrayReader(chars)) {
            int i;
            while((i = c.read()) != -1) {
                System.out.print((char)i);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сколько раз вызывался цикл while в методе showRead= " + count); // Зависит от переданного size

        }
    }

    /**
     * Метод такой же но используется беффер для вывода
     * @param size
     */
    public void getCharsShow(int size) {
        int count = 0;
        char[] chars = new char[str.length()]; // Источник данных
        str.getChars(0, str.length(), chars, 0); // Заполняем Источник данных
        try(CharArrayReader c = new CharArrayReader(chars)) {
            char[] buffer = new char[size]; // Буффер, сюда записываются данные
            int i;
            while((c.read(buffer)) != -1) {
                count++;
                for (int j = 0; j < buffer.length; j++) {
                    System.out.print(buffer[j]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Сколько раз вызывался цикл while = " + count); // Зависит от переданного size
        }
    }

    public static void main(String[] args) {
        CharArrayReaderShow c = new CharArrayReaderShow();
        c.showRead();
        c.getCharsShow(20);
    }
}

package io20.symbol.page752;

import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Записывает символы в файл.
 */
public class FileWriterShow {
    static String str = "Нет подключения к Интернету\n" +
            "Попробуйте сделать следующее:\n" +
            "\n" +
            "Проверьте сетевые кабели, модем и маршрутизатор.\n" +
            "Подключитесь к сети Wi-Fi ещё раз.\n" +
            "Выполните диагностику сети в Windows\n" +
            "DNS_PROBE_FINISHED_NO_INTERNET";

    /**
     *  С этой целью сначаа создается объкт типа
     * String, а затем вызывается метод getChars ( ) для извлечения эквиваентного
     * символьного массива.
     */
    public void getCharsUse(String path) {
        char[] buffer = new char[str.length()];
        // Copies characters from this string into the destination character
        //     * array.
        str.getChars(0, str.length(), buffer, 0);
        // Выводит на экран все
//        for (int i = 0; i < buffer.length; i++) {
//            System.out.print(buffer[i]);
//        }
        // Создаем файлы если они не существуют
        try(FileWriter f1 = new FileWriter(path + "file1.txt");
            FileWriter f2 = new FileWriter(path + "file2.txt");
            FileWriter f3 = new FileWriter(path + "file3.txt")) {
            // Выводим в первый файл КАЖДЫЙ ВТОРОЙ СИМВОЛ
            for (int i = 0; i < buffer.length; i+=2) {
                f1.write(buffer[i]);
            }
            // Выводит все символы во втрой файл
            f2.write(buffer);
            // Четверть символом
            f3.write(buffer, 50, 10); // Начиная с позици 50 выводит 10 символов
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Используется ByteArrayOutputStream
     * Метод write();
     */
    public void byteArrayOutputStreamUse() {
        // One more buffer
        byte[] bytes = str.getBytes();
        try(ByteArrayOutputStream b = new ByteArrayOutputStream(str.getBytes().length)) {
            b.write(bytes);
            for (int i = 0; i < bytes.length; i++) {
                System.out.print((char)bytes[i]);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\symbol\\page752\\";
        FileWriterShow f = new FileWriterShow();
        f.getCharsUse(path);
    }
}

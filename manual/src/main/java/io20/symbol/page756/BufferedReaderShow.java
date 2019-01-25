package io20.symbol.page756;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;

/**
 * Касс BufferedReader увеличивает производительность благодаря буфериза·
 * ции ввода. У него имеются следующие два конструора:
 * Вffereadr (Rar .о!ох .а)
 * Вfferedadr (Radr .o!oJ=.110.ra , int pS_cyte)
 * В первой форме конструктора созаетя буферизованный поток ввода симво
 * лов, использующий размер буфера по умоланию. В второй форме конструктра
 * зааея ра эмер_ буфера .
 */
public class BufferedReaderShow {

    static String str = "Файловый дескриптор — это неотрицательное целое число. " +
            "Когда создается новый &COPY; поток ввода-вывода, ядро возвращает процессу, " +
            "создавшему поток ввода-вывода, его файловый дескриптор.\n" +
            "\n" +
            "В операционной системе &COPY Windows для получения дескриптора файла его " +
            "необходимо открыть функцией CreateFile. Затем полученный дескриптор (или handle) " +
            "можно использовать для работы с этим файлом. Если это драйвер, " +
            "то дескриптор будет использоваться в функции DeviceIoControl.\n";

    /**
     * Метод ищет последовательность &COPY; если находит, заменяет ее на (c)
     */
    public void showReader() {
        char[] buff = new char[str.length()];
        str.getChars(0, str.length(), buff, 0);
        CharArrayReader in = new CharArrayReader(buff); // Принимает массив в качестве источника данных
        int c;
        boolean marked = false; // Маркируем если нашли символ который нужно найти
        try (BufferedReader b = new BufferedReader(in)){
            while ((c = b.read()) != -1) {
                switch (c) {
                    case '&':
                        if (!marked) {
                            // маркируем до следующего нахождения нужного символа.
                            // Эта метка сохранится пока мы не пройдем впереде еще 32 символа!!!
                            b.mark(32);
                            marked = true;
                        }
                        break;
                    case ';':
                        if (marked) {
                            marked = false;
                            System.out.print("(C)"); // Нашли нужную последовательность
                        } else {
                            System.out.print((char) c); // Выводим просто символ, это не наша ИСКОМАЯ последовательность
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            b.reset(); // возвращаемся на 32 символа назад
                            System.out.print("&"); // Выводим & вместо (c)
                        } else {
                            System.out.print((char) c); // Если это не пробел то выводим просто символ
                        }
                        break;
                    default:
                        if (!marked) {
                            System.out.print((char)c); // если не маркирован, то просто символ выводим
                        }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        BufferedReaderShow b = new BufferedReaderShow();
        b.showReader();
    }
}

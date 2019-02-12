package io20.symbol.page761;

import java.io.Console;

/**
 * Он служит для ввода-вывода данных на консоль, если ткова имеется, и реализует интерфейс
 * FlushaЫe. Касс Console является служебным, поскольку он функционирует
 * главным образом через стандартные потоки ввода-вывода System . in и System .
 * out . Тем н е менее он упрощает некоторые виды консольных операций, особенно
 * при чтении символьных строк с консоли
 */
public class ConsoleShow {
    public static void main(String[] args) {
        String str;
        Console console;

        // Получить ссылку на консоль
        console = System.console();

        // Если консоль недоступна то выходим из программы.
        if (console == null) {
            System.out.println("Консоль недоступна");
            return;
        }

        str = console.readLine("Введите строку: ");
        console.printf(" Бведенная вам строка : % s\n " , str);
    }
}

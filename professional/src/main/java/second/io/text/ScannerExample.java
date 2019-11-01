package second.io.text;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Класс сканер может использовать любой поток ввода!
 */
public class ScannerExample {

    /**
     * Метод просто читает строку из потока ввода и выводит ее на консоль
     * @param inputStream
     */
    public void universalScanner(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }

    /**
     * В этом статическом методе запускается два потока;
     * В одном происходит чтение из файла, в другос с консоли!
     * @param args
     */
    public static void main(String[] args) {
        ScannerExample sc = new ScannerExample();
        Runnable runnable = () -> {
            try {
                sc.universalScanner(new FileInputStream(new File("professional/src/main/java/second/io/ReadableExample.java")));
            } catch (IOException i) {
                i.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        sc.universalScanner(System.in);
    }
}

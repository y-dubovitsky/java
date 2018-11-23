package main.java.io13.page366;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;

        // Чтобы через консоль не вводить.
        args = new String[100];
        args[0] = "C:\\projects\\fullManual\\src\\main.java.io13\\page366\\file.txt";

        // Вводим путь к файлу из консоли.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            args[0] = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Не удалось считаь с клавиатуры");
        }

        if (args.length == 0) {
            System.out.println("Введите правильное имя файла!");
            return;
        }
        try {
            fin = new FileInputStream(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("Файл с таким именем не найден!");
            return;
        }
        try {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.println((char)i);
                }
            } while (i != -1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения из файла");
        }
        finally {
            try {
                fin.close();
            } catch (IOException e) {
                System.out.println("Не удалось закрыть файл!");
            }
        }
    }
}

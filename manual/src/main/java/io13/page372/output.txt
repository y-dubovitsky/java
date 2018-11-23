package main.java.io13.page372;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TryResource {
    public static void main(String[] args) {

        int i;

        args = new String[2];
        args[0] = "C:\\projects\\fullManual\\src\\main.java.io13\\page372\\TryResource.java";
        args[1] = "C:\\projects\\fullManual\\src\\main.java.io13\\page372\\output.txt";

        try(FileInputStream fileInputStream = new FileInputStream(args[0]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[1])) {

            do {
                i = fileInputStream.read();
                if (i != -1) fileOutputStream.write((char)i);
                else {
                    System.out.println("Копирование завершено!");
                }
            } while(i != -1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

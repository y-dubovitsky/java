package io20.bytes.example6;

import java.io.*;

public class BufferShow {
    private static File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\bytes\\example6\\BufferShow.java");

    public static void main(String[] args) {
        byte[] bytes = new byte[10]; // Массив байтов
        int count = 0;
        try(FileInputStream f = new FileInputStream(file); ByteArrayOutputStream b = new ByteArrayOutputStream()) {
            while (f.read(bytes) != -1) // Записывает байты в МАССИВ!!!
            {
                b.write(bytes);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Количество циклов = " + count);
        }
    }
}

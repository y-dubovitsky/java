package io20.bytes.page736;

import java.io.*;

/**
 * Касс B yteArrayOutput S t ream реаи3ует поток вывода, исполЬ3ующий мае·
 * сив байтов в качестве аресат
 */
public class ByteArrayOutputStreamShow {
    byte[] bytes = ("глагол:\n" +
            "вводить (enter, input, introduce, inject, set, bring in)\n" +
            "вносить (introduce, enter, bring in, import, move, carry in)\n" +
            "представлять (represent, present, introduce, furnish, perform, deliver)\n" +
            "знакомить (meet, introduce, acquaint, acquaint with, initiate)\n" +
            "применять (use, apply, employ, practice, deploy, introduce)\n" +
            "включать (include, turn on, switch on, comprise, involve, activate)\n" +
            "привносить (introduce, import, superinduce)\n" +
            "устанавливать (install, set, establish, place, set up, mount)\n" +
            "вставлять (insert, inset, interpose, paste, embed, plug)\n" +
            "вносить на рассмотрение (introduce)\n" +
            "вводить в употребление (introduce)\n" +
            "предварять (introduce)\n" +
            "предпосылать (precede, premise, preface, prefix, introduce)").getBytes();
    ByteArrayOutputStream b;

    public ByteArrayOutputStreamShow() {
        this.b = new ByteArrayOutputStream();
    }

    /**
     * Записываем байты в буфер, а потов выводим в консоль.
     */
    public void write() {
        try {
            b.write(bytes); // записываем наши байты в буфер ByteArrayOutputStream; смотри супер класс!!
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(b.toString()); // Выводит массив как символьную строку.
    }

    /**
     * Записываем в массив byte[]
     */
    public void writeToByteArray() {
        System.out.println("Работает метод writeToByteArray");
        byte[] result = b.toByteArray();
        for (int i = 0; i < result.length; i++) {
            System.out.print((char)result[i]);
        }
    }

    /**
     * Записываем массив байтов в файл!
     * @param file - файл для записы
     */
    public void writeToFile(File file) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(b.toByteArray());
        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ByteArrayOutputStreamShow b = new ByteArrayOutputStreamShow();
        b.write();
        b.writeToByteArray();
        // Создаем файл
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page736\\out.txt");
        try{
            file.createNewFile();
            b.writeToFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

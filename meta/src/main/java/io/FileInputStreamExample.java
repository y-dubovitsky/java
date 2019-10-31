package io;

import java.io.File;
import java.io.FileInputStream;

public class FileInputStreamExample {

    private static final String PATH = "meta/src/main/resources/io/file.txt";
    private static final File FILE = new File("meta/src/main/resources/io/file.txt");

    public void stringFromFile(String path, int flag) {
        try(FileInputStream input = new FileInputStream(path)) {
            switch (flag) {
                case (1) : {
                    int value;
                    while ((value = input.read()) != -1)
                        System.out.println((char) value);
                    break;
                }
                default: {
                    while (input.available() > 0)
                        System.out.println((char) input.read());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] getBytesArray(File file) {
        byte[] buffer = null;
        try(FileInputStream input = new FileInputStream(file)) {
            // byte[size] = count of available bytes in input files;
            buffer = new byte[input.available()];
            input.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return buffer;
        }
    }

    public static void main(String[] args) {
        FileInputStreamExample input = new FileInputStreamExample();
        input.stringFromFile(PATH, 1);
        // для наглядности
        for (int i = 0; i < input.getBytesArray(FILE).length; i++) {
            System.out.print((char)input.getBytesArray(FILE)[i]);
        }
    }
}

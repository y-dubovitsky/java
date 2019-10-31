package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * How to work with FileOutputStream in java
 */
public class FileOutputStreamExample {

    private static final String PATH = "meta/src/main/resources/io/file.txt";
    private static final File FILE = new File("meta/src/main/resources/io/file.txt");

    /**
     * Write byte like numeric values into file
     * @param path
     */
    public void writeToFile(String path) {
        try(FileOutputStream out = new FileOutputStream(path)) {
            out.write(1234);
        } catch (FileNotFoundException f) {

        } catch (IOException f) {
            f.printStackTrace();
        }
    }

    /**
     * Write to file string like bytes array
     */
    public void writeStringLikeByte(String str, File file) {
        try(FileOutputStream out = new FileOutputStream(file, true)) {
            byte[] bytes = str.getBytes();
            out.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileOutputStreamExample e = new FileOutputStreamExample();
        e.writeToFile(PATH);
        e.writeStringLikeByte("Hello, my name is", FILE);
    }

}

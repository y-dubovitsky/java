package second.io.file_filter;

import java.io.*;
import java.util.zip.ZipInputStream;

public class ZipInputExample {

    private static File zipFile = new File("professional/src/main/resources/second/io/text.zip");

    //TODO Не работает корректоно
    public static void main(String[] args) {
        try {
            ZipInputStream zipInput = new ZipInputStream(new FileInputStream(zipFile));
            DataInputStream dataInput = new DataInputStream(zipInput);
            while (dataInput.available() != -1) {
                System.out.print((char)dataInput.read());
            }
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

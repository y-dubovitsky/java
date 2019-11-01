package second.io;

import java.io.*;
import java.nio.CharBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * In this class we uses method from the Readable interface
 */
public class ReadableExample {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(1028);
        try(FileReader reader = new FileReader("professional/src/main/java/second/io/ReadableExample.java")) {
            // выводится количество считанных значений типа char
            System.out.println(reader.read(buffer));
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

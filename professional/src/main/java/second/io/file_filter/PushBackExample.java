package second.io.file_filter;

import java.io.*;

/**
 * In this class we will show you how to use PushbackInput;
 */
public class PushBackExample {

    private static final File file = new File("professional/src/main/java/second/io/ReadableExample.java");

    public static void main(String[] args) throws IOException {

        PushbackInputStream pb;

        DataInputStream data = new DataInputStream(
                pb = new PushbackInputStream(
                        new BufferedInputStream(
                                new FileInputStream(file)
                        )
                )
        );
        while (data.available() > 0) {
            int b = pb.read();
            if (b != '8') { // если не равен 8 то заталкиваем обратно
                pb.unread(b);
            } else {
                System.out.println("Hello");
                break;
            }
            System.out.print((char)data.read());
        }
    }
}

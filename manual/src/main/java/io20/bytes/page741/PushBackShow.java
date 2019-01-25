package io20.bytes.page741;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.PushbackInputStream;

/**
 * Делаем push-back.
 */
public class PushBackShow {
    private static String str = "Process finished with exit code 0";

    public static void main(String[] args) {
        int value;
        try(PushbackInputStream b = new PushbackInputStream(new ByteArrayInputStream(str.getBytes()))) {
            while ((value = b.read()) != -1) {
                switch (value) {
                    case ' ' :
                        System.out.print("_");
                        b.unread(value);
                        Thread.sleep(1000);
                        break;
                    default:
                        System.out.print((char)value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException m) {
            m.printStackTrace();
        }
    }
}

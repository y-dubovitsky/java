package io20.bytes.example3;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamShow {
    private String str = "hello my name is % ! and i am % troll";

    public void doS() {
        ByteArrayInputStream ar = new ByteArrayInputStream(str.getBytes());
        int var;
        boolean mark = false;
        try(BufferedInputStream b = new BufferedInputStream(ar)) {
            while ((var = b.read()) != -1) {
                switch(var) {
                    case '%' : if (!mark) {
                        mark = true;
                        b.mark(100);
                    }
                    break;
                    case '!' : if (mark) {
                        mark = false;
                        System.out.print("Попадание в %!");
                    }
                    break;
                    default:
                        System.out.print((char) var);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedInputStreamShow b = new BufferedInputStreamShow();
        b.doS();
    }
}

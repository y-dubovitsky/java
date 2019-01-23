package io20.page739;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo {
    private String s = "Это знак авторского права &сору; " +
            ", а &сору - нет . \\n";

    public void something() {
        byte[] bytes = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int c;
        boolean marked = false;
        try(BufferedInputStream b  = new BufferedInputStream(in)) {
            while((c = b.read()) != -1) {
                switch (c) {
                    case('&'):
                        if (!marked) {
                            b.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case (';'):
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char)c);
                        }
                        break;
                    case (' '):
                        if (marked) {
                            marked = false;
                            b.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if (!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BufferedInputStreamDemo b = new BufferedInputStreamDemo();
        b.something();
    }
}

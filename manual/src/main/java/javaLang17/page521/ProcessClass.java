package main.java.javaLang17.page521;

import java.io.InputStream;
import java.io.OutputStream;

public class ProcessClass extends Process {
    public static void main(String[] args) {

    }

    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }

    @Override
    public InputStream getErrorStream() {
        return null;
    }

    @Override
    public int waitFor() throws InterruptedException {
        return 0;
    }

    @Override
    public int exitValue() {
        return 0;
    }

    @Override
    public void destroy() {

    }
}

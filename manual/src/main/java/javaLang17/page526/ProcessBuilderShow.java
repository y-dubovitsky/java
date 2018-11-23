package main.java.javaLang17.page526;

import java.io.File;
import java.io.IOException;

public class ProcessBuilderShow {
    public static void main(String[] args) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("notepad.exe", "testfile");
        builder.start();
        File file = builder.directory();
        System.out.println(file);
    }
}

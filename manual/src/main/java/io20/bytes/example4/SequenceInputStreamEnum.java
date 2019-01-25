package io20.bytes.example4;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamEnum implements Enumeration<FileInputStream> {
    private Enumeration<String> files;

    public SequenceInputStreamEnum(Vector<String> files) {
        this.files = files.elements();
    }

    public boolean hasMoreElements() {
        return files.hasMoreElements();
    }

    public FileInputStream nextElement() {
        try {
            return new FileInputStream(files.nextElement().toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class SequenceInputStreamDemo {
    public static void main(String[] args) {
        int c;
        Vector<String> files = new Vector<String>();
        files.addElement("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\example4\\file1.txt");
        files.addElement("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\example4\\file2.txt");
        SequenceInputStreamEnum s = new SequenceInputStreamEnum(files);
        InputStream in = new SequenceInputStream(s);
        try{
            int value;
            while((value = in.read()) != -1) {
                System.out.print((char)value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

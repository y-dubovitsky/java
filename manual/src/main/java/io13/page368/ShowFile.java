package main.java.io13.page368;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        args = new String[2];
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            args[0] = bufferedReader.readLine();
            args[1] = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try {
            fileInputStream = new FileInputStream(args[0]);
            fileOutputStream = new FileOutputStream(args[1]);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            for (i = fileInputStream.read(); i != -1; ) {
                fileOutputStream.write(i);
                i = fileInputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fileInputStream.close();fileOutputStream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

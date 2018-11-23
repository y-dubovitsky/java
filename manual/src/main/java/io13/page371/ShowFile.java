package main.java.io13.page371;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            args = new String[1];
            try {
                args[0] = bufferedReader.readLine();
            } catch (IOException e) {
                System.out.println("Введите название файла!");
            }
        } while (args.length < 1);

        try(FileInputStream fileInputStream = new FileInputStream(args[0])) {
            do {
                i = fileInputStream.read();
                if (i != - 1) System.out.print((char) i);
            } while (i != -1);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

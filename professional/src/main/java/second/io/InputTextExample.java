package second.io;

import java.io.*;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputTextExample {

    private final static File FILE = new File("professional/src/main/resources/second/io/inputtext.txt");

    /**
     * Use Scanner for output text from the file
     */
    public void scannerOutput() {
        try(Scanner scanner = new Scanner(new FileReader(FILE))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use BufferedReader for output text from the file;
     */
    public void bufferedReaderOut() {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE)))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use static method from the Files class;
     */
    public void stringReader() {
        try {
            List<String> list = Files.readAllLines(FILE.toPath());
            for (String s : list) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Use stream
     */
    public void streamReader() {
        try {
            Stream<String> stream = Files.lines(FILE.toPath());
            // used various intermediate function
            stream.filter(x -> x.length() > 20)
                    .map((x) -> {
                        Integer[] in = new Integer[x.length()];
                        for (int i = 0; i < x.length(); i++) {
                            in[i] = new Random().nextInt();
                        }
                        return in;
                    })
                    .forEach(x -> {
                        for (int i = 0; i < x.length; i++)
                            System.out.print(x[i]);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        InputTextExample ite = new InputTextExample();
        ite.scannerOutput();
        ite.bufferedReaderOut();
        ite.stringReader();
        ite.streamReader();
    }
}

package second.io.binary;

import java.io.*;
import java.util.stream.Stream;

public class DataInputOutputExample {

    private static String path = "professional/src/main/resources/second/io/binary/text.txt";

    public byte[] getBytes(String str) {
        return str.getBytes();
    }

    /**
     * Этот метод берет массив байтов, и записывает его в файл как строку!
     * @param bytes
     * @param path
     */
    public void writeToFile(byte[] bytes, String path) {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(path)))){
            // Attention! Да все верно, этот метод берет массив байтов и записывает их в файл как строки!
//            for (int i = 0; i < bytes.length; i++) {
//                System.out.println(bytes[i]);
//            }
            out.write(bytes);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void readFromFile(String path) {
        try(DataInputStream in = new DataInputStream(new FileInputStream(new File(path)))) {
            Character c;
            while ((c = in.readChar()) != null) {
                System.out.println(c);
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DataInputOutputExample d = new DataInputOutputExample();
        //d.writeToFile(d.getBytes("Hello"), path);
        d.readFromFile(path);
    }
}

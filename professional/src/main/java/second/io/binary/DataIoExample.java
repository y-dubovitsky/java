package second.io.binary;

import java.io.*;

public class DataIoExample {

    private static final File FILE = new File("professional/src/main/resources/second/io/dataio.txt");

    //TODO Not Work!
    public static void readData() {
        try(DataInputStream inputStream = new DataInputStream(new FileInputStream(FILE))) {
            while (inputStream.available() > 0) {
                String k = inputStream.readUTF();
                System.out.println(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getString(BufferedReader reader) {
        String str = null;
        try {
            str = reader.readLine() + System.lineSeparator();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return str;
        }
    }

    public static void writeData() {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE, true))) {
            BufferedReader reader = new BufferedReader(
                    new FileReader("professional/src/main/java/second/io/DataIoExample.java"));
            for (int i = 0; i < 10; i++) out.writeBytes(getString(reader));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeData();
        readData();
    }
}

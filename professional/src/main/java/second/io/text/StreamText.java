package second.io.text;

import java.io.*;
import java.util.Properties;
import java.util.stream.Stream;

public class StreamText {

    private final static File FILE = new File("professional/src/main/resources/second/io/inputtext.txt");

    /**
     * Utils method, which return all SystemProperties;
     */
    private void getSysteProperties() {
        Properties properties = System.getProperties();
        for (String str : properties.stringPropertyNames()) {
            System.out.println("NAME " + str + " VALUE " + properties.get(str));
        }
    }

    /**
     * In this method file processes like string
     * @param args
     */
    public static void main(String[] args) {
        // gets stream
        try(Stream<String> stream = new BufferedReader(new InputStreamReader(new FileInputStream(FILE))).lines()) {
            stream.filter((s -> s.length() > 100))
                    .forEach((System.out::println));
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}

package streams.operations;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.stream.Stream;

public class DropWhileDemo {
    public static void main(String[] args) {
        Stream.of("Red", "Black", "Blue", "Qweater")
                .dropWhile(x -> x != "Blue")
                .forEach(System.out::println);

        // loading stream from properties file
        FileInputStream fis;
        Properties property = new Properties();

        try {
            // TODO java.io.FileNotFoundException:
            fis = new FileInputStream("/resources/second/streams/operations/config/config.properties");
            property.load(fis);
            Stream.of(property)
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

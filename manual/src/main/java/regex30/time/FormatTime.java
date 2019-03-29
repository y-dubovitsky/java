package regex30.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Format date
 */
public class FormatTime {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        // That all folks;
        System.out.println(localDateTime.format(DateTimeFormatter.ISO_TIME));
    }
}

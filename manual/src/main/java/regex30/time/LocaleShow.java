package regex30.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * This class show how to use LocalDateTime class;
 */
public class LocaleShow {
    public static void main(String[] args) {

        // used static method
        LocalDateTime localDateTime = LocalDateTime.now();

        // out date and time
        System.out.println(localDateTime);

        // convert DateTime to Time adn Date;
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println("LocalDate = " + localDate + "" +
                " LocalTime = " + localTime);
    }
}

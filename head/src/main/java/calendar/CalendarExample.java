package calendar;

import java.util.Calendar;
import static java.lang.System.out;

/**
 * This class show how to use Calendar class:
 */
public class CalendarExample {

    /**
     * Main method
     */
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 17; i++) {
            // used static import
            out.println(calendar.get(i));
        }
    }
}

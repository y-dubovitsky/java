package regex30.text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User format
 */
public class SmplDateFormat {
    public static void main(String[] args) {
        // Create timestamp
        Date date = new Date();

        // User format
        DateFormat dateFormat = new SimpleDateFormat("hh : mm : ss");

        // out
        System.out.println(dateFormat.format(date));
    }
}

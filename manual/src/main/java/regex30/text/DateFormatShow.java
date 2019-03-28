package regex30.text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Use Date format.
 */
public class DateFormatShow {
    public static void main(String[] args) {

        // Into object date contain current date and timestamp.
        Date date = new Date();

        DateFormat dateFormat;
        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);

        // Use our format(Short, English);
        System.out.println(dateFormat.format(date));
    }
}

package regex30.text;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeFormatShow {
    public static void main(String[] args) {
        Date date = new Date();

        // TimeFormat
        DateFormat dateFormat;
        dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.US);
        System.out.println("What`s time in US? Answer: " + dateFormat.format(date));
    }
}

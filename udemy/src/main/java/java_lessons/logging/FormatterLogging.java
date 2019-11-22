package java_lessons.logging;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Simple formatter
 */
public class FormatterLogging extends Formatter {
    @Override
    public String format(LogRecord record) {
        return record.getLevel() + " : " + record.getMessage();
    }
}

package java_lessons.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Filter
 */
public class FilerLogging implements Filter {

    private static Properties properties;
    private static final Logger GLOBAL_LOGGER = Logger.getGlobal();

    static {
        properties = new Properties();
        try {
            properties.load(new FileReader(new File("udemy/src/main/resources/java_lessons/logging/filter.properties")));
        } catch (FileNotFoundException f) {
            GLOBAL_LOGGER.log(Level.ALL, "FilerLogging.class", f);
        } catch (IOException e) {
            GLOBAL_LOGGER.log(Level.ALL, "IOException", e);

        }
    }

    @Override
    public boolean isLoggable(LogRecord record) {
        System.out.println("Filter executed");
        return record.getMessage().startsWith(properties.getProperty("first"));
    }
}

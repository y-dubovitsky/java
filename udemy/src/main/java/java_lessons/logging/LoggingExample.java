package java_lessons.logging;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.*;

//TODO Сделать так чтобы можно было выводить логи в Сокет и Стримы=) ну если время будет
public class LoggingExample {

    /**
     * Global logger and logging with own properties from resources file.
     * На самом деле, если мы применяем свои Properties, то они распространяются и на Global Logging!
     */
    private static final Logger LOGGER_GLOBAL = Logger.getGlobal();
    private static final Logger LOGGER_OWN_PROPERTIES = Logger.getLogger(LoggingExample.class.getCanonicalName());

    private static final String path = "E:/log.txt";

    private static Filter filter = new FilerLogging();

    private static Formatter formatter = new FormatterLogging();

    public static void main(String[] args) throws Exception {
        // init
        LoggingExample loggingExample = new LoggingExample();
        // settings
        loggingExample.applyOwnLogginGonfiguration();
        loggingExample.setHandler(LOGGER_OWN_PROPERTIES, path);
        //loggingExample.unsetParentLogging(LOGGER_OWN_PROPERTIES); delete handler by default
        // set filter
        loggingExample.setFilterHandler(filter, LOGGER_OWN_PROPERTIES);
        // set formatter
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(formatter);
        LOGGER_OWN_PROPERTIES.addHandler(consoleHandler);
        // execute
        LOGGER_OWN_PROPERTIES.info("dont know what");
        loggingExample.exceptionImitation();
    }

    /**
     * Устанавливаем обработчик(перехватчик, укротитель) как FileHandler
     *
     * ЕСТЬ ЕЩЕ 3 Handlers - стримы(I/O), сокеты, консоль
     * @param logger
     * @throws Exception
     */
    public void setHandler(Logger logger, String path) throws Exception {
        FileHandler fileHandler = new FileHandler(path);
        logger.addHandler(fileHandler);
    }

    //TODO Попробуй написать
    /**
     * ставим handler как Сокет
     * @param host
     * @param port
     */
    public void socketHandler(String host, int port) {
        try {
            SocketHandler socketHandler = new SocketHandler(host, port);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Set Filter
     * @param filterHandler
     * @param logger
     */
    public void setFilterHandler(Filter filterHandler, Logger logger) {
        logger.setFilter(filterHandler);
    }

    public void infoLogging() {
        LOGGER_GLOBAL.info("Hello from info");
    }

    /**
     * Этот метод убирает грубо говоря надстройку; т.е. например
     * по умолчанию у нас все выводится в консоль, если false выставим, то будет выводиться туда, куда
     * куда мы укажем в addHandler
     * @param logger
     */
    public void unsetParentLogging(Logger logger) {
        logger.setUseParentHandlers(false);
    }

    public void getAllLoggingLevel() {
        LOGGER_OWN_PROPERTIES.log(Level.FINEST, "FINEST");
        LOGGER_OWN_PROPERTIES.log(Level.FINER, "FINER");
        LOGGER_OWN_PROPERTIES.log(Level.FINE, "FINE");
        LOGGER_OWN_PROPERTIES.log(Level.CONFIG, "CONFIG");
        LOGGER_OWN_PROPERTIES.log(Level.INFO, "INFO");
        LOGGER_OWN_PROPERTIES.log(Level.WARNING, "WARNING");
        LOGGER_OWN_PROPERTIES.log(Level.SEVERE, "SEVERE");
    }

    public void getLoggingPropertiesFile() {
        System.out.println("Properties: " + System.getProperty("java.util.logging.config.file"));
    }

    /**
     * В этом методы мы имитируем исключение и записываем ее в лог!
     */
    public void exceptionImitation() {
        try {
            for (int i = 0; i < 100; i++) {
                if (i == 50) throw new NullPointerException();
            }
        } catch (Exception e) {
            LOGGER_OWN_PROPERTIES.log(Level.FINE, "Exception imitation", e);
        }
    }

    /**
     * Этот метод подгружает собственную конфигурацию для логера.
     * НЕ забудь добавить VM Options.
     * -Djava.util.logging.config.file=udemy/src/main/resources/java_lessons/logging/loggin.properties
     */
    private void applyOwnLogginGonfiguration() {
        try {
            LogManager.getLogManager().readConfiguration();
        } catch (IOException i) {
            // А вот так не получится =) потому что логер не сконфигурирован.
            //LOGGER_OWN_PROPERTIES.log(Level.WARNING, i.getMessage(), i);
            i.printStackTrace();
        }
    }

    /**
     * Utils class
     */
    static class Utils {

        /**
         * Тут конечно выведется false, потому что сравниваются ссылки(на области в памяти),
         * т.е. у двух объектов разные области в памяти, но могут быть одинаковые значения в полях.
         * @param logger1
         * @param logger2
         */
        private static void equalsLogging(Logger logger1, Logger logger2) {
            System.out.println(logger1.equals(logger2));
        }

        /**
         * Выводит все системные свойства
         */
        private static void getAllSystemProperties() {
            Properties properties = System.getProperties();
            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
            entries.stream()
                    .forEach(x ->
                            System.out.println(x.getKey() + " : " + x.getValue()));
        }
    }
}


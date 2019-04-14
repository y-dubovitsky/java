package formatter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Formatter;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Simple Format example
 */
public class FormatExample {

    /**
     * Method with variable length of arguments.
     */
    public void variableLenArgMethod(String name, double ... d) {
        System.out.println(d.getClass().getCanonicalName());
        System.out.println(name + d);
    }

    /**
     * Method is formatting numbers
     */
    public void numbersFormat() {
        Object[] arg = Stream
                .of(
                        "%, d",
                        "Мне нужно исправить %.2f ошибок",
                        "Просто заменим знак %,2f на какой то текст",
                        "One more %,d replace")
                .toArray();
        Object[] value = new Object[]{
                100000000,
                3894.23423523,
                1234.9800,
                11110000
        };

        // do format
        for (int i = 0; i < arg.length; i++) {
            System.out.println(String.format((String) arg[i], value[i]));
        }
    }

    /**
     * Method form something and write result in file
     */
    public void toFileOutFormat() {
        // Try format file
        File file = new File("C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\java\\formatter\\toFormat");
        System.out.println(file.getTotalSpace());
        try {
            Formatter formatter = new Formatter(file);

            //FixME
            //TODO Доделать, типа он берет в последовательности определяет количество знаков "%"
            // и передает это количество аргументов... ну ты понял, надеюсь =)
            // Pattern pattern = Pattern.compile("%");
            // Math math = pattern.matcher(CharSequence....)

            // Отформатировал и записал в файл
            formatter.format("%.2f", 1234.9800).flush();
        } catch (FileNotFoundException f) {
            f.printStackTrace();
        }
    }

    /**
     * THis method do date format
     * @param date
     */
    public void dateFormat(Date date, String... str) {
        Formatter f = new Formatter();
        for (int i = 0; i < str.length; i++) {
            System.out.println(
                    // Если не создать новый объект, то форматирование "накладывается" друг на друга
                    f.format(str[i], date)
                            .toString());
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        FormatExample fr = new FormatExample();
        fr.variableLenArgMethod("Аргументы", 0.0, 0.4, 123.5);
        // Date format
        fr.dateFormat(new Date(), "%tA", "%td", "%tB");
    }
}

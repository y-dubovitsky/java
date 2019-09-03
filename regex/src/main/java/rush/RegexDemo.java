package rush;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexDemo {
    public static void demonstration (String[] args)
    {
        if (args.length != 2)
        {
            System.err.println("usage: java RegexDemo regex input");
            return;
        }
        // Преобразуем символьные последовательности начала новой строки (\n) в символы начала строки.
        args[1] = args[1].replaceAll("\\\\n", "\n");
        try
        {
            System.out.println("regex = " + args[0]);
            System.out.println("input = " + args[1]);
            Pattern p = Pattern.compile(args[0]);
            Matcher m = p.matcher(args[1]);
            while (m.find())
                System.out.println("Found [" + m.group() + "] starting at "
                        + m.start() + " and ending at " + (m.end() - 1));
        }
        catch (PatternSyntaxException pse)
        {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }
    }

    public static void main(String[] args) {
        // Простые классы символов
        RegexDemo.demonstration(new String[]{"[csw]", "cave floor in minoc mine"});
        // Инвертированные классы символов
        RegexDemo.demonstration(new String[]{"[^cave]", "cave floor in minoc mine"});
        // Диапазонные классы символов
        RegexDemo.demonstration(new String[]{"[^a-e]", "cave floor in minoc mine"});
        // Слияние нескольких диапазонов
        RegexDemo.demonstration(new String[]{"[a-zA-Z]", "ABCD abcd"});
        // Объединение классов символов
        RegexDemo.demonstration(new String[]{"[ab[f]]", "abcdef"});
        // Пересечение классов символов
        RegexDemo.demonstration(new String[]{"[abcdef&&[abc]]", "ab ccc def"});
        // Вычитание классов символов
        RegexDemo.demonstration(new String[]{"[abcdef&&[^ac]]", "abcdef"});
        // Предопределенные классы символов
        RegexDemo.demonstration(new String[]{"[\\d]", "1234567"});
        // Граничные сопоставители
        RegexDemo.demonstration(new String[]{"^[\\d]*", "1234+1234"});
        // Вложенные флаговые выражения
        RegexDemo.demonstration(new String[]{".at(?x)#match hat, cat, and so on", "matter"});
    }
}

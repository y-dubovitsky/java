package main.java.javaLang17.page528;

import java.io.Console;
import java.util.Map;

public class SystemShow {
    public static void main(String[] args) {
        // СЧитаем сколько времени исполняется программа
        long start;
        start = System.currentTimeMillis();
        Console console = System.console();
        Map map = System.getenv();
        System.out.println(map.entrySet());
        System.out.println("Программа выполняется примерно " + (System.currentTimeMillis() - start) + " миллиСекунд");
        // Применение arrayCopy
        int[] ints = {1,2,3,4,5,6,7,8,9,0};
        for (int a : ints) {
            System.out.print(a);
        }
        System.arraycopy(ints, 0, ints, 2, ints.length - 2);
        System.out.print(System.lineSeparator());
        for (int a : ints) {
            System.out.print(a);
        }
        System.out.println(System.lineSeparator());
        // Переменные окружения
        System.out.println(System.getProperty("java.class.path"));
    }
}

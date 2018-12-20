package lambda15.example14;

/**
 * Функциональный интерфейс
 */
interface Interface {
    String getName(String str);
}

/**
 * Класс, показывающий работу.
 */
public class RefOnStaticMethod {

    /**
     * Статическая функция.
     * @param str
     * @return
     */
    static String something(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    /**
     * Что-то делает
     * @param i - функциональный интерфейс, может быть передана функция, реализующая тот же функционал.
     * @param str - строка.
     * @return
     */
    static String func(Interface i, String str) {
        return i.getName(str);
    }

    public static void main(String[] args) {
        Interface i = (String s) -> {
            return s.toUpperCase();
        };
        // Передается функция в качестве функ.ин
        System.out.println(RefOnStaticMethod.func(RefOnStaticMethod::something, "Hello"));
        // Передается лямбда-выражение
        System.out.println(RefOnStaticMethod.func(i, "теперь я написан большими буквами"));
    }
}

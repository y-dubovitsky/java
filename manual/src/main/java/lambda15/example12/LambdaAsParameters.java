package lambda15.example12;

import lambda15.example11.LambdaAsParam;

/**
 * Обобщенный интерфейс.
 * @param <T>
 */
interface Interface<T> {
    /**
     * Абстрактный метод.
     * @return
     */
    abstract T getValue();

    /**
     * Метод по умолчанию, возвращает имя интерфейса.
     * @return
     */
    default String getName() {
        return Class.class.getName();
    }
}

/**
 * Класс, показывающий 'лямбда как параметр'
 */
public class LambdaAsParameters<T> {

    /**
     * Метод класса принимает в качестве входного параметра лямбда-выражение.
     * @param str
     */
    public void method(Interface<T> str) {
        System.out.println(str.getValue()); // Работаем с результатом лямбда-выражения.
    }

    public static void main(String[] args) {
        LambdaAsParameters lambdaAsParameters = new LambdaAsParameters();
        lambdaAsParameters.method(() -> {
            String result = "1";
            int i = 0;
            do {
                result += result + " ";
                i++;
            }while (i < 5);
            return result;
        });
        // Лямбда-выражение.
        lambdaAsParameters.method(() -> {
            return 12345.4;
        });
        Interface<Integer> inf = () -> {
            int result = 0;
            for (int i = 0; i < 10; i++) {
                result += i;
            }
            return result;
        };
        lambdaAsParameters.method(inf);
    }
}

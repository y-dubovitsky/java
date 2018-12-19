package lambda15.example11;

/**
 * Функциональный интерфейс.
 */
interface Interf {
    /**
     * Абстрактный метод.
     */
    abstract String getValue(String t);
}

/**
 * Класс, показывающий как лямбда-выражение передается в качетсве параметра.
 */
public class LambdaAsParam {
    /**
     * Метод, который что то делает.
     * @param interf - Принимает в качестве параметра лямбда-выражение.
     * @param str
     * @return
     */
    public String getS(Interf interf, String str) {
        return interf.getValue(str);
    }

    public static void main(String[] args) {
        LambdaAsParam lambdaAsParam = new LambdaAsParam();
        System.out.println(lambdaAsParam.getS((String str) -> {
            String result = "";
            for (int i = 0; i < 10; i++) {
                result += str;
            }
            return result;
        }, "Hello"));
    }
}

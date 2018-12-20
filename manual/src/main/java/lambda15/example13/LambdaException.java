package lambda15.example13;

/**
 * Функциональный интерфейс
 * @param <T> - обобщенный параметр.
 */
interface Interface<T> {
    abstract MyClass getParameter(T t);
}

/**
 * Собственный класс
 * @param <T>
 */
class MyClass<T> {
    /**
     * Обобщенный метод
     * @param str - строка
     * @return
     */
    public T MyMethod(String str) {
        return (T)str;
    }
}

public class LambdaException {
    int value = 0;
    Interface<String> str = (String n) -> {
        MyClass result = new MyClass();
        // изменяем переменную класса
        value++;
        if (n.length() == 1) {
            // результату присваивается анонимный класс.
            return new MyClass() {
                String something() {
                    return "Inner Method";
                }
                @Override
                public Object MyMethod(String str) {
                    return super.MyMethod(something());
                }
            };
        }
        return result;
    };

    /**
     * Главный метод
     * @param args
     */
    public static void main(String[] args) {
        LambdaException lambdaException = new LambdaException();
        System.out.println("lambdaException.value = " + lambdaException.value);
        MyClass myClass = lambdaException.str.getParameter("1");
        System.out.println(myClass.MyMethod("1"));
        System.out.println("lambdaException.value = " + lambdaException.value);
    }
}

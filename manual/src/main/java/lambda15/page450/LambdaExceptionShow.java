package lambda15.page450;

/**
 * Функциональный интерфейс.
 */
interface NumericArrayInterface {
    double func(double[] n) throws EmptyArrayException;
}

/**
 * Собственное исключение.
 */
class EmptyArrayException extends Exception {
    EmptyArrayException(String error) {
        super(error);
    }
}

/**
 * Класс показывает работу исключений в лямбда выражениях.
 */
public class LambdaExceptionShow {
    private double[] doubleArray;

    LambdaExceptionShow(double[] n) {
        this.doubleArray = n;
    }

    public static void main(String[] args) throws EmptyArrayException {
        NumericArrayInterface numericArrayInterface = (n) -> {
            int i = 0;
            double sum = 0;
            if (n.length == 0) throw new EmptyArrayException("Массив Пуст Бро!");
                do {
                    System.out.println(i + " слагаемое - " + n[i]);
                    sum += n[i];
                    i++;
                } while(i < n.length);
            return sum;
        };
        LambdaExceptionShow lambdaExceptionShow = new LambdaExceptionShow(new double[]{23.5, 43.5, 34.5});
        System.out.println(numericArrayInterface.func(lambdaExceptionShow.doubleArray));
        // Создаем еще один экземпляр класса:
        LambdaExceptionShow les = new LambdaExceptionShow(new double[]{});
        System.out.println(numericArrayInterface.func(les.doubleArray));
    }
}

package first.multithreading;

class Handler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(this.getClass().getCanonicalName());
    }
}

/**
 * Обработчик необрабатываемых исключений;
 * Результат работы:
 * first.multithreading.Handler // В первом вариате будет вызван метод из переданного обработчика class Handler
 *
 * Exception in thread "Thread-1" java.lang.ArithmeticException: / by zero
 * 	at first.multithreading.ThreadHandler.lambda$main$0(ThreadHandler.java:26)
 * 	at java.base/java.lang.Thread.run(Thread.java:834)
 */
public class ThreadHandler extends ThreadDeath {

    private static int variable = 0;

    public static void main(String[] args) {
        Runnable runnable = () -> {
            try {
                // This is unchecked exception!
                for (int i = 0; i < 10; i++) {
                    System.out.println(i/0);
                }
                // and this is too
                if (variable == 0)
                throw new NullPointerException("null point");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(ThreadHandler.class.getCanonicalName());
            }
        };
        // Создаем поток и передаем ему обработчик необрабатываемых исключений
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        // Устанавливаем обработчик на потока номер 1
        thread.setUncaughtExceptionHandler(new Handler());
        thread.start();
        thread1.start();
    }
}

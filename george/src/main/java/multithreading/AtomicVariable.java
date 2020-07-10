package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Данный класс показывает что такое и как работать с атомарными переменными.
 */
class AtomicVariable {

    private static final int COUNT_ITERATION = 1000;
//    static int var = 0; //* не атомарно
    static AtomicInteger var = new AtomicInteger(0); //* атомарно

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < COUNT_ITERATION; i++) {
            new DefaultThread().start(); //! Обрати внимание, что каждый поток увеличивает var на 1 и умирает, т.е. 100
        }
        Thread.sleep(10_000);
        System.out.println("Final var = " + var);
    }

    static class DefaultThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            var.incrementAndGet();
        }
    }
}

package first.multithreading;

import java.util.ArrayList;
import java.util.List;

/**
 * В этом примере показано, что если во время выполнения потока приходит запрос на прерывание,
 * а поток находится в состоянии sleep(блокирован), то он пудет завершен с исключением.
 */
public class InterruptExample {

    /**
     * Runnable with sleep method
     */
    public static Runnable getRunnable() {
        Runnable r = () -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                long end = System.currentTimeMillis() - start;
                System.out.println(Thread.currentThread().getName() + " is interrupted after " + end + " mills");
            }
        };
        return r;
    }

    public static void main(String[] args) {
        /**
         * List of threads
         */
        List<Thread> threads = new ArrayList<>();

        /**
         * Add 100 threads into the list;
         */
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(getRunnable()));
            threads.get(i).start();
        }

        /**
         * Interrupt all threads
         */
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).interrupt();
        }
    }
}

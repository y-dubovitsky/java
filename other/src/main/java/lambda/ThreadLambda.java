package lambda;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Lambda like a object;
 */
public class ThreadLambda {
    public static void main(String[] args) {
        Thread one = new Thread(() -> {
            Thread.currentThread().setName("First Thread");
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        });

        Thread two = new Thread(() -> {
            Thread.currentThread().setName("Second Thread");
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        });

        // save lambda as object
        Runnable runnable = () -> System.out.println("Threed thread");

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(one);
        service.execute(two);
        service.execute(runnable);
        service.shutdown();
    }
}

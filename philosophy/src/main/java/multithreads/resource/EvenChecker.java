package multithreads.resource;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int value = generator.next();
            if (value % 2 != 0) {
                System.out.println(value + " нечетное");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executor.execute(new EvenChecker(generator, i));
            executor.shutdown();
        }
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}

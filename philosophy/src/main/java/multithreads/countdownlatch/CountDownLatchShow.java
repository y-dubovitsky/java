package multithreads.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class TaskPortion implements Runnable {

    private static int counter = 0;

    private final int id = counter++;

    private static Random random = new Random(47);

    private final CountDownLatch latch;

    TaskPortion(CountDownLatch c) {
        latch = c;
    }

    @Override
    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            System.out.println(this.id + " interrupted");
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100 + random.nextInt());
        System.out.println(this.id + " completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }
}

class WaitingTask implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    WaitingTask(CountDownLatch c) {
        latch = c;
    }

    @Override
    public void run() {
        try {
            System.out.println(id + " waiting");
            latch.await();
            System.out.println(this + " stop waiting!");
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
    }
}

public class CountDownLatchShow {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            e.execute(new WaitingTask(latch));
        }
        for (int j = 0; j < SIZE; j++) {
            e.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all Tasks");
        e.shutdown();
    }
}

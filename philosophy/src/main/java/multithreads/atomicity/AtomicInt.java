package multithreads.atomicity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class show how to use atomic-classes for simple type;
 */
public class AtomicInt implements Runnable{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAtomicInteger() {
        return atomicInteger.get();
    }

    private void evenIncrement() {
        atomicInteger.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        // Created timer, end TimerTask started after 5 second
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Stop!");
                System.exit(0);
            }
        }, 5000);
        ExecutorService service = Executors.newCachedThreadPool();
        AtomicInt at = new AtomicInt();
        service.execute(at);
        while (true) {
            int i = at.getAtomicInteger();
            if (i % 2 != 0) {
                System.out.println("Value = " + i);
                System.exit(0);
            }
        }
    }
}

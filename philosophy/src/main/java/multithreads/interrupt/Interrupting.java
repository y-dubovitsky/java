package multithreads.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class SleepingBlocking implements Runnable{

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting from SleepingBlocking");
    }
}

class IOBlocking implements Runnable {

    InputStream inputStream;

    public IOBlocking(InputStream i) {
        inputStream = i;
    }

    @Override
    public void run() {
        try {
            System.out.println("Waiting IS");
            inputStream.read();
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from IOBlocking");
            }
        }
    }
}

class SynchronizedBlocking implements Runnable {

    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocking() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    @Override
    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting from SynchronizedBlocking");
    }
}

public class Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException{
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupted " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupted sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception {
        test(new SleepingBlocking());
        test(new IOBlocking(System.in));
        test(new SynchronizedBlocking());
        TimeUnit.SECONDS.sleep(3);
        System.exit(0);
    }
}

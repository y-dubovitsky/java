package multithreads.local;

import java.util.Random;

/**
 * Philosophy java page - 942
 */
class Accessor extends Thread {

    private final int id;

    public Accessor (int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            ThreadLocalVarHolder.increment();
            System.out.println(this);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException!");
            }
            Thread.yield();
        }
    }

    @Override
    public String toString() {
        return "id = " + id + " " + ThreadLocalVarHolder.get();
    }
}

public class ThreadLocalVarHolder {

    /**
     * Static local thread variable; Initial with random int
     * Для каждого потока своя копия переменной (вроде я правильно понял)
     */
    private static ThreadLocal<Integer> value = new ThreadLocal<>() {
        private Random random = new Random(47);
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws Exception{
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread starting");
                    for (int i = 0; i < 5; i++) {
                        new WrapperThread(new Accessor(i)).setDaemon().start();
                    }
                    Thread.sleep(10000);
                    System.out.println("Main thread ending");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

/**
 * Daemon wrapper
 */
class WrapperThread {

    private Thread thread;

    public WrapperThread(Thread runnable) {
        this.thread = runnable;
    }

    public Thread setDaemon() {
        thread.setDaemon(true);
        return thread;
    }
}

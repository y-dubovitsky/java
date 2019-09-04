package multithreads.blockingqueue.lift;

import multithreads.LiftOff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.*;

class LiftOffRunner implements Runnable {

    /**
     * queue with threads
     */
    private BlockingQueue<LiftOff> queue;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        this.queue = queue;
    }

    /**
     * Add new thread into queue
     * @param l
     */
    public void add(LiftOff l) {
        try {
            queue.put(l);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff liftOff = queue.take();
                // starting thread from queue
                liftOff.run();
            }
        } catch (InterruptedException e) {
            System.out.println("Waking from take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}

public class StartBlockingQueue {
    /**
     * This method needed for interrupting threads
     */
    static void getkey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Simple method for time-interrupting
     * @param time
     */
    static void getkey(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static void getkey(String msg) {
        System.out.println(msg);
        getkey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner liftOffRunner = new LiftOffRunner(queue);
        Thread thread = new Thread(liftOffRunner);
        thread.start();
        for (int i = 0; i < 5; i++) {
            liftOffRunner.add(new LiftOff(10));
        }
        //getkey("Press 'Enter' " + msg + " !");
        getkey(5);
        thread.interrupt();
        System.out.println("Finished " + msg + " test");
    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        test("SynchronousQueue", new SynchronousQueue<LiftOff>());
        test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
    }
}

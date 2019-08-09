package multithreads.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        // trying to get lock
        boolean capture = lock.tryLock();
        try {
            System.out.println("tryLock: " + capture);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // if locking, then unlocking
            if (capture) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("lock.tryLock(2, TimeUnit.SECONDS) " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attempt = new AttemptLocking();
        attempt.untimed();
        attempt.timed();
        // created new thread and this thread trying to get object private ReentrantLock lock
        // если этот объект заблокирован то выводится сообщение "bad try"
        new Thread() {
            {
                // thread ending work, when all other not daemon threads, ending working
                setDaemon(true);
            }
            public void run() {
                boolean trying = attempt.lock.tryLock();
                if (!trying) {
                    System.out.println("Bad try");
                }
                try {
                    Thread.sleep(50000);
                } catch (InterruptedException e) {
                    System.out.println("Daemon ending");
                }
            }
        }.start();
        Thread.yield();
        attempt.untimed();
        attempt.timed();
    }
}

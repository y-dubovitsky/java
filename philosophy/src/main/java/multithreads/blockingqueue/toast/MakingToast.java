package multithreads.blockingqueue.toast;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

/**
 * Toast CLass
 */
class Toast {

    /**
     * Toast status
     */
    public enum Status { DRY, BUTTERED, JAMMED }

    private Status status = Status.DRY;

    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERED;
    }

    public void dry() {
        status = Status.DRY;
    }

    public void jam() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast " + id + " : " + status;
    }
}

class ToastQueue extends LinkedTransferQueue<Toast> {}

class Toaster implements Runnable {

    private ToastQueue toasts;

    private Random random = new Random(13);

    private int count = 0;

    public Toaster(ToastQueue queue) {
        this.toasts = queue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.SECONDS.sleep(100 + random.nextInt());
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toasts.put(toast);
            }
        } catch (InterruptedException i) {
            System.out.println("Toaster interrupted");
        }
    }
}

class Buttere implements Runnable {

    private ToastQueue dryQueue, butteredQueue;

    public Buttere(ToastQueue... v) {
        dryQueue = v[0];
        butteredQueue = v[1];
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = dryQueue.take();
                toast.butter();
                System.out.println(toast);
                butteredQueue.put(toast);
            }
        } catch (InterruptedException i) {
            System.out.println("Buttered interrupted");
        }
    }
}

class Jamed implements Runnable {

    private ToastQueue butteredQueue, jamQueue;

    public Jamed(ToastQueue... t){
        this.butteredQueue = t[0];
        this.jamQueue = t[1];
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = butteredQueue.take();
                toast.jam();
                System.out.println(toast);
                jamQueue.put(toast);
            }
        } catch (InterruptedException i) {
            System.out.println("Jammed interrupted");
        }
    }
}

class BreakFast implements Runnable {

    private ToastQueue queue;

    private int counter = 0;

    public BreakFast(ToastQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast toast = queue.take();
                if (toast.getStatus() != Toast.Status.JAMMED ||
                toast.getId() != counter++) {
                    System.exit(1);
                }
                System.out.println(toast);
            }
        } catch (InterruptedException i) {
            System.out.println("BreakFast interrupted");
        }
    }
}

public class MakingToast {
    public static void main(String[] args) throws InterruptedException{
        ToastQueue dryQueue = new ToastQueue(),
                butteredQueue = new ToastQueue(),
                jamQueue = new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Buttere(dryQueue, butteredQueue));
        executorService.execute(new Jamed(butteredQueue, jamQueue));
        executorService.execute(new BreakFast(jamQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

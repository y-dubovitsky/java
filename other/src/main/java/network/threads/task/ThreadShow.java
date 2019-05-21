package network.threads.task;

import java.util.Random;

/**
 * This class demonstrate how works main thread and task new thread.
 */
public class ThreadShow {

    Runnable runnable;
    long seed;

    public ThreadShow(Runnable runnable, long seed) {
        this.runnable = runnable;
        this.seed = seed;
    }

    public static void main(String[] args) {
        ThreadShow threadShow = new ThreadShow(new Task(), 14L);
        Thread thread = new Thread(threadShow.runnable);
        thread.start();
        threadShow.printRandomNumbers();
    }

    public void printRandomNumbers() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Random(seed));
        }
    }
}

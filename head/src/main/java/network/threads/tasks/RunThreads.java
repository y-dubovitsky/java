package network.threads.tasks;

/**
 * This class extends Thread class; But this is a bad practice;
 * More better if this class implements Runnable;
 */
public class RunThreads extends Thread {

    public static void main(String[] args) {
        Thread thread = new Thread(new Action("C:"));
        thread.setName("SubThread");
        thread.start();
        RunThreads runThreads = new RunThreads();
        runThreads.setName("MainThread");
        runThreads.start();
        System.out.println("Thread.currentThread().getName() - " + Thread.currentThread().getName());
    }

    public void run() {
        simple();
    }

    public void simple() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

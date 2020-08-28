package space.dubovitsky.advanced.multithread;

public class VolatileDemo {

    private volatile boolean flag;

    VolatileDemo(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {

        VolatileDemo volatileDemo = new VolatileDemo(true);

        volatileDemo.runTwoThread();

        System.out.println("Main Thread finished work!"); //! Main thread end
    }

    private void runTwoThread() { //? Как сделать так, чтобы поток закэшировал flag?
        new Thread(() -> {
            while (flag) {
                System.out.println("Time: " + System.currentTimeMillis() + " " + flag);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
                flag = false;
                System.out.println("Thread with time shout down! " + flag);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}

package multithreading;

/**
 * Как работает wait/notify
 */
public class WaitNotifyFirst {

    public static void main(String[] args) {
        DefaultThread defaultThread = new DefaultThread();
        defaultThread.start();
        synchronized (defaultThread) { //! Если убрать этот блок, то главные поток отработает первым и выведет просто int var = 0; Получается что wait/notify - это некий аналог join
            try {
                defaultThread.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(defaultThread.var);
    }


    static class DefaultThread extends Thread {

        int var = 0;

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 10; i++) {
                    var++;
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                notify();
            }
        }
    }

}

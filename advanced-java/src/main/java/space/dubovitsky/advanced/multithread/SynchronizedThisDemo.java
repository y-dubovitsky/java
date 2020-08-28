package space.dubovitsky.advanced.multithread;

/**
 * Пример простой синхронизации.
 *
 * Инкремент вынесен в отдельный синхронизированный метод
 */
public class SynchronizedThisDemo {

    private int value;

    public static void main(String[] args) {
        SynchronizedThisDemo demo = new SynchronizedThisDemo();
        demo.value = 0;

        demo.incrementValueInTwoThreads();
        demo.showValue();
    }

    private void incrementValueInTwoThreads() {
        Thread first = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });

        Thread second = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                increment();
            }
        });

        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
    }

    private synchronized void increment() { //! Синхронизация по this
        int temp = value;
        temp = temp + 1;
        value = temp;
    }

    private void showValue() {
        System.out.printf("Value = %s", value);
    }

}

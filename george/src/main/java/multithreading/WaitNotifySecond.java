package multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Еще один пример wait/notify.
 * В это примере один поток записывает данные в список, другой как только в списке появились данные читает их из него
 */
class WaitNotifySecond {

    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) {
        ProducerThread producerThread = new ProducerThread();
        producerThread.start();

        ConsumerThread consumerThread = new ConsumerThread();
        consumerThread.start();
    }

    static class ProducerThread extends Thread {
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                synchronized (list) { //! Синхронизация нужна по одному объекту!
                    list.add(scanner.nextLine());
                    list.notify(); //! Уведомляет второй поток(т.е. тот, что синхронизирован по обекту list), что закончил работу
                }
                try {
                    Thread.sleep(1000); //? TODO Не вполне понял это Поточное голодание?
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ConsumerThread extends Thread {
        @Override
        public void run() {
            while (list.isEmpty()) {
                synchronized (list) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(list.remove(0));
                }
            }
        }
    }
}

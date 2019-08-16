package multithreads.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitWax() throws InterruptedException{
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void waitBuffed() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

class Waxing implements Runnable {

    private Car car;

    public Waxing(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Наносим Воск");
                TimeUnit.SECONDS.sleep(1);
                // Нанесли воск
                car.waxed();
                // Пока воск не убрали, ждем!
                car.waitBuffed();
            }
        } catch (InterruptedException i) {
            System.out.println("Wax interrupted");
        }
    }
}

class Buffed implements Runnable {

    private Car car;

    public Buffed(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Buffed car");
                TimeUnit.SECONDS.sleep(1);
                car.waitWax();
                car.buffed();
            }
        } catch (InterruptedException i) {
            System.out.println("Buffed interrupted");
        }
    }
}

public class WaxAuto {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Buffed(car));
        executorService.execute(new Waxing(car));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

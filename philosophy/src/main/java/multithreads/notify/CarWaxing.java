package multithreads.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car {

    private boolean waxOn = false;

    /**
     * Ready for waxing
     */
    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    /**
     * Ready for buffer
     */
    public synchronized void buffed() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitingForWaxing() throws Exception{
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingForBuffed() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}

class WaxOn implements Runnable {

    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("WaxOn!");
                TimeUnit.MILLISECONDS.sleep(100);
                car.waxed();
                car.waitingForBuffed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ending of Wax");
    }
}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWaxing();
                TimeUnit.MILLISECONDS.sleep(100);
                car.buffed();
                System.out.println("Wax Off");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ending Buffed");
    }
}

public class CarWaxing {
    public static void main(String[] args) throws Exception{
        Car car = new Car();
        ExecutorService e = Executors.newCachedThreadPool();
        e.execute(new WaxOff(car));
        e.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        e.shutdownNow();
    }
}

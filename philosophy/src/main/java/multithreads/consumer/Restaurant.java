package multithreads.consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Meal {
    /**
     * Number of order
     */
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }
}

class WaitPerson implements Runnable {

    private Restaurant restaurant;

    public WaitPerson(Restaurant r) {
        this.restaurant = r;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("Waitperson got " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException i) {
            System.out.println("Waitperson interrupted");
        }
    }
}

class Chef implements Runnable {

    Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                // Если шеф приготовил 10 блюд, то завершаем все нити!
                if (count > 10) {
                    System.out.println("Kitchen is closed");
                    restaurant.executr.shutdownNow();
                }
                System.out.println("Chef starting cocking ");
                synchronized (restaurant.waitPerson) {
                    restaurant.meal = new Meal(count++);
                    restaurant.waitPerson.notifyAll();
                }
                TimeUnit.SECONDS.sleep(3);
            }
        } catch (InterruptedException i) {
            System.out.println("Chef interrupted");
        }
    }
}

public class Restaurant {
    Meal meal;
    ExecutorService executr = Executors.newCachedThreadPool();
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    public Restaurant() {
        executr.execute(chef);
        executr.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

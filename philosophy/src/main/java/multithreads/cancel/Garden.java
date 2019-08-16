package multithreads.cancel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count {
    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int getCount() {
        return count;
    }
}

class Entrance implements Runnable {

    private static Count count = new Count();

    private static List<Entrance> list = new ArrayList<>();

    /**
     * Count of entrance;
     */
    private int number = 0;

    private final int id;

    private static volatile boolean canceled = false;

    public static void cancel() {
        canceled = true;
    }

    public Entrance(int id) {
        this.id = id;
        list.add(this);
    }

    @Override
    public void run() {
        while (!canceled) {
            // В качестве объекта синхронизации указан уникальный объект!
            synchronized (this) {
                // Увеличивает свой счетчик
                ++number;
            }
            // Каждый поток увеличивает счетчик в статическом классе Count!
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + " : " + getValue();
    }

    public static int getTotalCount() {
        return count.getCount();
    }

    public static int sumEntrances() {
        int sum = 0;
        for(Entrance e : list) {
            sum += e.getValue();
        }
        return sum;
    }
}

public class Garden {
    public static void main(String[] args) throws Exception {
        ExecutorService e = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            e.execute(new Entrance(i));
        }
        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        e.shutdown();
    }
}

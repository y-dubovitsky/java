package multithreads.cyclicbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

//TODO Not Work! Why?
class Horse implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static Random random = new Random(47);
    private static CyclicBarrier cyclicBarrier;

    public Horse(CyclicBarrier c) {
        cyclicBarrier = c;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += random.nextInt(3);
                }
                // wait while all threads invoke .await();
                cyclicBarrier.await();
            }
        } catch (InterruptedException e) {
            System.out.println(this.getClass().getCanonicalName() + " interupted");
        } catch (BrokenBarrierException b) {
            throw new RuntimeException(b);
        }
    }

    @Override
    public String toString() {
        return "Horse " + id + " ";
    }

    /**
     * Graphic method
     * @return
     */
    public String tracks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
            sb.append(id);
        }
        return sb.toString();
    }
}
public class HorseRace {
    private static final int FINAL_LINE = 75;
    private List<Horse> list = new ArrayList<>();
    private ExecutorService service = Executors.newCachedThreadPool();
    private CyclicBarrier cyclicBarrier;

    public HorseRace(int horseCount, final int pause) {
        cyclicBarrier = new CyclicBarrier(horseCount, new Runnable() {
            @Override
            public void run() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < FINAL_LINE; i++)
                    sb.append("=");
                System.out.println(sb);
                for (Horse horse: list)
                    System.out.println(horse.tracks());
                for (Horse horse: list)
                    if (horse.getStrides() >= FINAL_LINE) {
                        System.out.println(horse + " WON!");
                        service.shutdownNow();
                        return;
                    }
                try {
                    TimeUnit.SECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("HorseRace interrupted!");
                }
            }
        });
        for (int i = 0; i < horseCount; i++) {
            Horse horse = new Horse(cyclicBarrier);
            list.add(horse);
            service.execute(horse);
        }
    }

    public static void main(String[] args) {
        int countHorse = 7;
        int pause = 200;
        new HorseRace(countHorse, pause);
    }

}

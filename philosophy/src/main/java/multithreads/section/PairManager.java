package multithreads.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class PairManager {

    AtomicInteger atomicInteger = new AtomicInteger(0);
    protected Pair pair = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(pair.getX(), pair.getY());
    }

    protected void store(Pair p) {
        storage.add(p);
        try {
            // delay
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

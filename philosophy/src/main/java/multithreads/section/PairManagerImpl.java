package multithreads.section;

public class PairManagerImpl extends PairManager {

    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }

}

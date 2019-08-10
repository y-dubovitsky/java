package multithreads.sync.object;

/**
 * This example show how we can use various objects in synchronized block
 */
class DualSynch {

    /**
     * Object for synchronized
     */
    private Object syncObject = new Object();

    public void f() {
        // Attention! Синхронизация производися по двум разным объектам! ->
        // методы выполняются одновременно и они не блокируют друг друга!!!
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println("f()");
                Thread.yield();
            }
        }
    }

    public void g() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}

public class SynchObject {
    public static void main(String[] args) {
        final DualSynch dual = new DualSynch();
        new Thread() {
            public void run() {
                dual.f();
            }
        }.start();
        dual.g();
    }
}


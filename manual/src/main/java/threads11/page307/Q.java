package main.java.threads11.page307;

public class Q {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.print("CATCHED!");
            }
        }
        System.out.println("Получено " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int i) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Попался InterruptedException!");
            }
        }
        this.n = i;
        System.out.println("Отправлено " + n);
        valueSet = true;
        notify();
    }
}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int i = 0;

        while (true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while (true) {
            q.get();
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
    }
}
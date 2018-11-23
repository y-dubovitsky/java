package main.java.threads11.page306;

public class Q {
    int n;

    int get() {
        System.out.println("Получено " + n);
        return n;
    }

    void put(int n) {
        this.n = n;
        System.out.println("Отправлено " + n);
    }
}

class Producer implements Runnable {
    Q q;

    Producer(Q q) {
        this.q = q;
        new Thread(this, "Поставщик").start();
    }

    public void run() {
        int i = 0;
        // Это неверно, так мы вошли в цикл который синхронизируется и это не даст запустить второй поток,
        // который будет вечно ждать пока мы выйдем из монитора. Как то так.
        //synchronized (q) {
            while (true) {
                synchronized (q) {
                    q.put(i++);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    //
                }
            }
        //}
    }
}

class Consumer implements Runnable {
    Q q;

    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Получатель").start();
    }

    public void run() {
        //synchronized (q) {
            while (true) {
                synchronized (q) {
                    q.get();
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    //
                }
            }
        //}
    }
}

class PC {
    public static void main(String[] args) {
        Q q = new Q();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);
    }
}


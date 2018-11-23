package main.java.threads11.page298;

class NewThread implements Runnable {
    String threadName;
    protected Thread t;
    // Приоритет потока
    static int priority = 1;

    NewThread() {
        t = new Thread(this, "Новый Поток!");
        System.out.println("Создали новый поток: " + t);
        t.start();
        t.setPriority(priority++);
    }

    NewThread(String name) {
        this.threadName = name;
        t = new Thread(this, threadName);
        t.setPriority(priority++);
        System.out.println("Создали новый поток: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(threadName + " " + i);
                t.sleep(500);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Дочерник поток завершен");
    }
}


class Demo {
    public static void main(String[] args) {
        NewThread thread1 = new NewThread("One");
        NewThread thread2 = new NewThread("Two");
        NewThread thread3 = new NewThread("Three");
        Thread t = Thread.currentThread();
        try {
            //for (int i = 0; i < 5; i++) {
                System.out.println("Главный поток " + t);
                if (thread1.t.isAlive()) {
                    System.out.println(thread1.threadName + " еще работает!");
                }
                thread1.t.join();
                thread2.t.join();
                thread3.t.join();
                if (!thread1.t.isAlive()) {
                    System.out.println(thread1.threadName + " уже не выполняется");
                }
            //}
        } catch (InterruptedException e) {
            System.out.print("Главный поток прерван");
        }
        System.out.println("Главный поток завершен!");
    }
}

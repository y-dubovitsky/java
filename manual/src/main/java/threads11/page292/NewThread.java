package main.java.threads11.page292;

class NewThread extends Thread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Новый Поток!");
        System.out.println("Создали новый поток: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дочерний поток: " + i);
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
        Thread thread = new NewThread();
        Thread t = Thread.currentThread();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Главный поток " + t);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.print("Главный поток прерван");
        }
        System.out.println("Главный поток завершен!");
    }
}

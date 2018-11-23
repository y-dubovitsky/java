package main.java.threads11.page294;

public class NewThread extends Thread {
    NewThread(){
        super("КОНСТРУКТОР");
        System.out.println("Новое имя потока -> " + this.getName());
        start();
    }

    NewThread(String nameOfThread) {
        super(nameOfThread);
        this.start();
    }

    public void run() {
        //this.setName("Новый поток");
        System.out.println("Запустили побочный поток " + this.getName());
        int i = 0;
        while(true) {
            System.out.println(getName() + " " + i);
            i++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            System.out.println("Типа обработали =)");
        }
            if (i > 5) { break; }
        }
    }
}

class Demonstration {
    public static void main(String[] args ) {
        new NewThread();
        Thread thread = new NewThread("Еще один новый поток!");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Главный поток " + Thread.currentThread());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.print("Главный поток прерван");
        }
        System.out.println("Главный поток завершен!");
    }
}

package main.java.threads11.page290;

public class CurrentThread {
    public static void main(String[] args) {
        // static method current..
        Thread t = Thread.currentThread();
        System.out.println("Current thread: " + t.getName() + " " + t);
        //change name
        t.setName("New THread Name!");
        System.out.println("New name: " + t.getName());
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                t.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.print("Поймали ошибку прерывания потока!");
        }
    }
}

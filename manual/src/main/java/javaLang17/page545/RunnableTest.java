package main.java.javaLang17.page545;

class Show {
public static void main(String[]args) throws InterruptedException{
        RunnableTest runnableTest = new RunnableTest();
        ElseClass elseClass = new ElseClass();
        Thread thread = new Thread(runnableTest);
        thread.start();
        {
            System.out.println("УСТУПИ РЕСУРС ЦП СКА!");
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                Thread.sleep(50);
            }
            System.out.println("Уступки Закончились!");
        }
        Thread thread1 = new Thread(elseClass);
        thread1.start();
    }
}

public class RunnableTest implements Runnable {
    static volatile int start = 0;

    public void run() {
        try {
            this.tikTak();
        } catch (InterruptedException e) {
            System.out.println("CATHCed!");
        }
    }

    void tikTak() throws InterruptedException {
        while (start < 10) {
            System.out.println("tik");
            Thread.sleep(100);
        }
        System.out.println("БУМ БУМ БУМ " + start);
    }
}

class ElseClass implements Runnable {

    public void run() {
        try {
            this.check();
        } catch (InterruptedException e) {
            System.out.println("Catched in ElseClass");
        }
    }

    void check() throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            Thread.sleep(123);
            System.out.println("i = " + i);
            if (i > 5) {
                RunnableTest.start = 20;
            }
        }
    }
}

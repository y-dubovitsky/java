package main.java.javaLang17.page550;

class NewThread extends Thread {
    boolean suspendFlag;

    NewThread(String threadname, ThreadGroup tg) {
        super(tg, threadname);
        System.out.println("New Thread: " + this);
        suspendFlag = false;
        start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(getName() + ": " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in " + getName());
        }
        System.out.println(getName() + " ending...");
    }
    synchronized void mysuspend() {
        suspendFlag = true;
    }
    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}

public class ThreadGrShow {
    public static void main(String[] args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThread ob1 = new NewThread("One", groupA);
        NewThread ob2 = new NewThread("Two", groupA);
        NewThread ob3 = new NewThread("Three", groupB);
        NewThread ob4 = new NewThread("Four", groupB);

        System.out.println("\nOutputing from method .list():");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Interrupt Group A");
        Thread tga[] = new Thread[groupA.activeCount()];
        {
            //
            for (int i = 0; i < tga.length; i++) {
                System.out.println("До " + i + ": " + tga[i]);
            }
            // Что же изменилось?
            groupA.enumerate(tga);
            for (int i = 0; i < tga.length; i++) {
                System.out.println("После " + i + ": " + tga[i]);
            }
            //
        }
        for (int i = 0; i < tga.length; i++) {
            ((NewThread)tga[i]).mysuspend();
        }
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("Maint Thread was interrupted");
        }

        System.out.println("Starting Group A");
        for (int i = 0; i < tga.length; i++) {
            ((NewThread)tga[i]).myresume();
        }
        // waiting
        try {
            System.out.println("We are waiting thread ending...");
            ob1.join();
            ob2.join();
            ob3.join();
            ob4.join();
        } catch (Exception e) {
            System.out.println("Exception in Main Thread!");
        }
        System.out.println("Main Thread is Ending! =)");
    }
}

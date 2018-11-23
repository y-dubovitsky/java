package main.java.javaLang17.example1;

class MyThreadGroup {
    //static ThreadGroup gr1 = new ThreadGroup("Группа 1");
    //static ThreadGroup gr2 = new ThreadGroup("Группа 2");
}

class TestThread extends Thread {
    boolean isWorking = false;

    TestThread(String name, ThreadGroup threadGroup) {
        super(threadGroup, name);
        start();
    }

    public void run() {
        int i = 0;
        try {
            while (i < 10) {
                System.out.println(this.getName() + " " + this.getThreadGroup() + " " + i + " working");
                i++;
                Thread.sleep(500);
                synchronized (this) {
                    while (isWorking) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException ei) {
            System.out.println("\nГруппа " + this.getThreadGroup() + " прервана\n");
        }
    }

    synchronized void interruptThread() {
        isWorking = true;
    }

    synchronized void startThread() {
        isWorking = false;
        notify();
    }
}

//class InterTh implements Runnable {
//    public void run() {
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Пытаемся прервать gr2");
//            {
//                gr2.interrupt();
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                if (gr2.isDestroyed()) {
//                    System.out.println("\nМы все удачно прервали!\n");
//                } else {
//                    System.out.println("\nПрервать не получилось!\n");
//                }
//            }
//        }
//    }
//}

public class MyThreadGr {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup gr1 = new ThreadGroup("Группа 1");
        ThreadGroup gr2 = new ThreadGroup("Группа 2");
        TestThread t1 = new TestThread("Первый поток", gr1);
        TestThread t2 = new TestThread("Второй поток", gr1);
        TestThread t3 = new TestThread("Третий поток", gr2);
        TestThread t4 = new TestThread("Четвертый поток", gr2);
        TestThread t5 = new TestThread("Пятый поток", new ThreadGroup("Группа 3"));
        TestThread t6 = new TestThread("Шестой поток", new ThreadGroup("Группа 3"));
        //
        System.out.println("Пытаемся прервать gr2");
        {
            gr2.interrupt();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (gr2.isDestroyed()) {
                System.out.println("\nМы все удачно прервали!\n");
            } else {
                System.out.println("\nПрервать не получилось!\n");
            }
        }
        // Пауза
//        InterTh interTh = new InterTh();
//        Thread thread = new Thread(interTh);
//        thread.start();

        System.out.println("\nПробуем приостановить группу номер 1\n");
        Thread th[] = new Thread[gr1.activeCount()];
        gr1.enumerate(th);
        for (int i = 0; i < th.length; i++) {
            ((TestThread)th[i]).interruptThread();
        }
        // Запускаем группу 1
        Thread.sleep(5000);
        System.out.println("\nПробуем ЗАПУСТИТЬ группу номер 1\n");
        for (int i = 0; i < th.length; i++) {
            ((TestThread)th[i]).startThread();
        }
    }
}

package main.java.threads11.page302;

public class CallMe {
    synchronized void call(String msg) {
        System.out.print("[");
        System.out.print(msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e ) {
            e.getMessage();
        }
        System.out.print("]");
    }
}

class Caller implements Runnable {
    CallMe target;
    String msg;
    Thread t;

    Caller(CallMe callMe, String str) {
        target = callMe;
        msg = str;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}

class Synch {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();
        Caller caller = new Caller(callMe, "Дратутти!");
        caller.t.setName("Тестируемый поток ");
        while(caller.t.isAlive()) {
            System.out.println(caller.t.getName() + " еще выполняется");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                //
            }
        }
        new Caller(callMe, "Бро!");
        new Caller(callMe, "Человечище!");

    }
}

package main.java.threads11.page304;

public class CallMe {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // Не делай так. Обрабатывай исключения.
        }
        System.out.print("]");
    }
}

class Caller implements Runnable {
    CallMe callme;
    String msg;
    Thread thread;

    Caller(CallMe callme, String msg) {
        this.callme = callme;
        this.msg = msg;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        // Передаем сюда объект метод которого нужно синхронизировать.
        synchronized (callme) {
            callme.call(msg);
        }
    }
}

class Synch {
    public static void main(String[] args) {
        CallMe callMe = new CallMe();
        Caller caller1 = new Caller(callMe, "Hello");
        Caller caller2 = new Caller(callMe, "Привет");
        Caller caller3 = new Caller(callMe,"Дратутти");
        try {
            caller1.thread.join();
            caller2.thread.join();
            caller3.thread.join();
        } catch (InterruptedException e) {
            // Перехватываем исключение!
        }
    }
}

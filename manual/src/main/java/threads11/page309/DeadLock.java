package main.java.threads11.page309;

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();
    DeadLock() {
        Thread.currentThread().setName("Главный поток");
        Thread t = new Thread(this, "Соперничащий поток");
        t.start();
        a.foo(b);
        System.out.println("Возвращаемся в главный поток");
    }

    public void run() {
        b.bar(a);
        System.out.println("Назад в другой поток");
    }

    public static void main(String args[]) {
        new DeadLock();
    }
}

class A {
    synchronized void foo(B b) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод А.foo()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println(name + " пытаемся вызвать метод B.last()");
        b.last();
    }

    synchronized void last() {
        System.out.println("В методе last()");
    }
}

class B {
    synchronized void bar(A a) {
        String name = Thread.currentThread().getName();
        System.out.println(name + " вошел в метод B.bar()");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //
        }
        System.out.println("Пытаемся вызвать метод A.last()");
        a.last();
    }

    synchronized void last() {
        System.out.printf("В методе B.last()");
    }
}

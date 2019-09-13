package first.collections.add;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class A {
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

class B extends A {
    @Override
    public String toString() {
        return this.getClass().getName();
    }
}

//TODO Сделать так чтобы элементы заполнялись в двух разных потоках, а когда все заполнено
// чтобы итератор получить! Короче итератор ждет пока заполнятся списки
public class LinkedListIter {

    //TODO Убрать модификатор static
    static List<A> a = new LinkedList<>();
    static List<B> b = new LinkedList<>();
    ReentrantLock listLock = new ReentrantLock();

    public void fillList() {
        listLock.lock();
        try {

        } finally {
            listLock.unlock();
        }
    }

    public void bruteForce(List<?> list) {
        listLock.lock();
        try {
            while (list.size() < 0) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            listLock.unlock();
        }
    }

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                a.add(new A());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                b.add(new B());
            }
        }).start();
    }
}

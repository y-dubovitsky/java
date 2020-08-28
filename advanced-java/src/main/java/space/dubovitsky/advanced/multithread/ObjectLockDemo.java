package space.dubovitsky.advanced.multithread;

import java.util.ArrayList;
import java.util.List;

//TODO мб сделать рефакторинг, но тут все для наглядности

/**
 * Как работает код:
 *
 * Есть два листа и локи. Запускаются 2 потока и они заполняют два списка,
 * + идет синхронизацию. Для каждого потока свой лок, ну короче посмотри код вроде все ясно.
 */
public class ObjectLockDemo {

    public static void main(String[] args) {
        new FillList().startingTwoThread();
    }

    //! Inner class
    static class FillList {

        private List<Integer> firstList = new ArrayList<>();
        private List<Integer> secondList = new ArrayList<>();

        //* Locks
        private Object lockFirst = new Object();
        private Object lockSecond = new Object();

        /**
         * Заполняем переданный список и синхронизация по переданному объкту
         * @param list - список
         * @param lock - лок
         */
        public void fillList(List<Integer> list, Object lock) {
            synchronized (lock) {
                String name = Thread.currentThread().getName();
                for (int i = 0; i < 1000; i++) {
                    System.out.println(name);
                    list.add(i);
                }
            }
        }

        public void fillTwoLists() {
            fillList(firstList, lockFirst);
            fillList(secondList, lockSecond);
        }

        public void startingTwoThread() {

            Thread firstThread = new Thread(() -> {
                fillTwoLists();
            });

            Thread secondThread = new Thread(() -> {
                fillTwoLists();
            });

            //! Starting threads
            firstThread.start();
            secondThread.start();

            //! join
            try {
                firstThread.join();
                secondThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("firstList.size() = " + firstList.size());
            System.out.println("secondList.size() = " + secondList.size());

        }

    }
}

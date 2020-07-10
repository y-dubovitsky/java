package multithreading;

/**
 *      Thread live cycle:
 *
 * New -> Runnable -> Running -> Dead
 *        \                 /
 *         Blocking/waiting
 *
 * В этом примере рассматривается как использовать методы yield, join, sleep;
 * Статический метод Thread.yield - говорит текущему потоку уступить управление, но не факт что уступит!
 */
class ThreadLiveCycle {

    public static void main(String[] args) {

        Thread thread = new Thread(new ThreadJoin());
        thread.start();

        throw new RuntimeException("Method main was finished!"); //! Вероятнее всего этот поток отработает первым!
    }

    static class ThreadJoin implements Runnable {
        @Override
        public void run() { //! В методе Ран запускается еще один поток

            Thread localThread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000); //* Текущий поток засыпает на 1 секунду
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            });
            localThread.start();
            try {
                localThread.join(); //! Когда вызывается этот метод, то поток сперва отработает, а затем отработает тот поток, из которого он был вызван
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " finished work!");
        }
    }
}

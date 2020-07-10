package multithreading;

/**
 * Этот класс показывает 2 способа создания потоков, через наследование и имплиментацию интерфейса.
 *
 * Также показано, что невозможно повторно запустить завершенный поток.
 *
 * Также КАЖДЫЙ ПОТОК работает в своем стеке вызовово
 */
class ThreadCreate {

    public static void main(String[] args) {
        //! Exception thread
        Thread threadException = new Thread(new ThreadThrowException());
        threadException.start();

        //! First Thread
        ThreadExtend threadExtend = new ThreadExtend();
        threadExtend.start();

        //! Second Thread
        Thread thread = new Thread(new ThreadRunnable());
        thread.start();

        //! Невозможно запустить поток повторно
        try {
            Thread.sleep(10_000);
            thread.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class ThreadExtend extends Thread {
        @Override
        public void run() {
            Thread.currentThread().setName(this.getClass().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    static class ThreadRunnable implements Runnable {
        @Override
        public void run() {
            Thread.currentThread().setName(this.getClass().getName());
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }
    }

    static class ThreadThrowException implements Runnable {
        @Override
        public void run() {
            System.out.println(String.format("Thread name : %s", Thread.currentThread().getName()));
            throw new RuntimeException();
        }
    }
}





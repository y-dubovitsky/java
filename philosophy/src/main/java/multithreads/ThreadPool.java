package multithreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++)
//        service.execute(new LiftOff());
//        service.shutdown();

        // Создаем 5 потоков, ждем когда они отработают и еще 5 создается
        service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.execute(new LiftOff());
        }
        service.shutdown();
    }
}

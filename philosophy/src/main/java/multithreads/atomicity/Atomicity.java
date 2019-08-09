package multithreads.atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class show, how to work with atomicity opperation!
 */
public class Atomicity implements Runnable {

    private int i = 0;

    public int getI() {
        // Чисто теоретически это атомарная операция, но! это не так
        return i;
    }

    private synchronized void incrementI() {
        i++;
        i++;
    }

    public void run() {
        while (true) {
            incrementI();
        }
    }

    /**
     * Метод в итоге завершится, а это будет свидтельствовать о том
     * что атомарная операция не атомарна (читай книгу философия джава, там все подробно написано)
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Atomicity atomicity = new Atomicity();
        service.execute(atomicity);
        while (true) {
            int value = atomicity.getI();
            if (value % 2 != 0) {
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}

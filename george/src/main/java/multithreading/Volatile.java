package multithreading;

/**
 * Этот класс показывает как работает ключевое слово volatile
 *
 * Суть ключевого слова в том, что когда создается новый поток, помимо своего стека вызова функций у него есть и свои
 * так сказать переменные, и если мы не указываев volatile, то новый поток кеширует переменные и работает уже с ними
 *
 * Ключевое слово volatile говорит о том, чтобы все потоки работали с ОДНОЙ переменной
 */
public class Volatile {

    volatile static int value = 0;
//    static int value = 0;

    public static void main(String[] args) {
        volatileDemonstration();
    }

    private static void volatileDemonstration() {
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " changing value at " + ++value);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            int local = value;
            while (local < 5) {
                if (local != value) {
                    System.out.println("Static value was changed at " + local);
                    local = value;
                }
            }
        }).start();
    }
}

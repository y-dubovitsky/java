package multithreads;

public class MainThread {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}

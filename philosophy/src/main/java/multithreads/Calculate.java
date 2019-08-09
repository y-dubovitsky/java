package multithreads;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculate implements Runnable {

    private double d = 10;

    public Calculate() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            d = (Math.PI + Math.E) / d;
            System.out.println(d);
        }
    }

    public static void main(String[] args) throws Exception{
        new Calculate();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("User input: " + reader.readLine());
        reader.close();
    }
}

package multithreads;

import java.util.ArrayList;
import java.util.concurrent.*;

public class WithResult implements Callable<String> {
    private int id;

    public WithResult(int i) {
        this.id = i;
    }

    @Override
    public String call() throws Exception {
        return "result " + id;
    }

    static class Demo {
        public static void main(String[] args) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            ArrayList<Future<String>> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(executorService.submit(new WithResult(i)));
            }
            for (Future<String> f : list ) {
                try {
                    System.out.println(f.get());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    executorService.shutdown();
                }
            }
        }
    }
}

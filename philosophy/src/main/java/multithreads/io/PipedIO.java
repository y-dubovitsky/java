package multithreads.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class shows how to use IO class in MultiThreading app;
 * PipedWriter - PipedReader;
 */
class Sender implements Runnable {

    private PipedWriter writer;

    public Sender(PipedWriter pw) {
        this.writer = pw;
    }

    public PipedWriter getWriter() {
        return writer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (char i = 'A'; i < 'z'; i++) {
                    writer.write(i);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            }
        } catch (IOException | InterruptedException i) {
            System.out.println("Sender interrupted");
        }
    }
}

class Receiver implements Runnable {

    private PipedReader reader;

    /**
     * Attention! For getting reader, we need WRITER!
     * @param writer
     */
    public Receiver(PipedWriter writer) {
        try {
            reader = new PipedReader(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println((char)reader.read());
            }
        } catch (IOException e) {
            System.out.println("Receiver interrupted");
        }
    }
}

public class PipedIO {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newCachedThreadPool();
        PipedWriter pw = new PipedWriter();
        service.execute(new Receiver(pw));
        service.execute(new Sender(pw));
        TimeUnit.SECONDS.sleep(10);
        service.shutdownNow();
    }
}

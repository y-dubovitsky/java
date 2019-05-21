package network.threads.task;

import java.io.File;
import java.io.IOException;

/**
 * This class implements Runnable and need to starting second Thread in
 * other class
 */
public class Task implements Runnable {

    @Override
    public void run() {
        printNames();
    }

    /**
     * This method print all parents files names of temp file;
     */
    public void printNames() {
        try {
            File file = File.createTempFile("temp", "sample");
            File[] list = file.getParentFile().listFiles();
            for (File f : list) {
                Thread.sleep(1000);
                System.out.println(f.getAbsolutePath());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

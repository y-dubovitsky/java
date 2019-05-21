package network.threads.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * This class to testing.
 */
public class Action implements Runnable {

    private String dir;

    public Action(String dir) {
        this.dir = dir;
    }

    public void run() {
        dirs(this.dir);
    }

    /**
     * I don`t know how works this method!
     * @param path
     */
    public void dirs(String path) {
        File file = new File(path);
        try {
            Files.walkFileTree(file.toPath(), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    System.out.println(file.toAbsolutePath());
                    getThreadName();
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getThreadName() {
        System.out.println(Thread.currentThread().getName());
    }
}

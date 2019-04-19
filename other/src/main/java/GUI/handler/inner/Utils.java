package GUI.handler.inner;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Various utils for application.
 */
public class Utils {

    String path = "/text.txt";

    public Utils() {}

    public Utils(String path) {
        this.path = path;
    }

    /**
     * Getting random text from file
     * @return - random string
     */
    public String getText() {
        String result = "";
        try {
            // get file
            File file = new File(this.getClass().getResource(path).getFile());
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek((long)(Math.random() * file.length()));
            result = randomAccessFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

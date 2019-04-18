package GUI.animation;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Various utils for application.
 */
public class Utils {

    /**
     * Getting random text from file
     * @param path - path to file
     * @return - random string
     */
    public String getText(String path) {
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

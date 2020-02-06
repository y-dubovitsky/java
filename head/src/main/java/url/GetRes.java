package url;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * THis class read all data from URL and write it into file.
 */
public class GetRes {
    // url with data
    public URL url;
    // out file
    public File file;

    public GetRes(URL url, File file) {
        this.url = url;
        this.file = file;
    }

    /**
     * Getting all data from URL
     * @param url
     * @return
     */
    public DataInputStream getDataFromURL(URL url) {
        DataInputStream result = null;

        try {
            URLConnection urlConnection = url.openConnection();

            // create IO
            result = new DataInputStream(urlConnection.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Write data in file
     * @param is
     * @param file
     */
    public void writeDataToFile(DataInputStream is, File file) {
        if (is != null) {
            try(FileOutputStream f = new FileOutputStream(file)) {
                byte[] bytes = new byte[100];
                while (is.read(bytes) != -1) {
                    f.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
                // TODO add some kind of behavior
            }
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        GetRes getRes = new GetRes(new URL("https://github.com/y-dubovitsky/IDEA-HotKeys"),
                new File("C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\java\\url\\file.out"));
        getRes.writeDataToFile(getRes.getDataFromURL(getRes.url), getRes.file);
    }
}

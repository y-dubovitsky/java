package second.io.binary;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteReadBinary {

    private static File file;

    /**
     * Simple Singleton! Return file;
     * NOT Thread-safe!
     */
    public File getFile(String path) {
        if (file == null) {
            file = new File(path);
        }
        return file;
    }

    public void writeString(File file, String str) {
        try(DataOutputStream out =  new DataOutputStream(new FileOutputStream(file))) {
            // В файл запишутся имеено входные строки
            out.writeChars(str);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void writeInt(File file, Integer in) {
        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            // В файл будет записан символ соответствующей номеру кодовой точки in
            // 123 = {
            out.writeInt(in);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WriteReadBinary wr = new WriteReadBinary();
        wr.getFile("C:\\Users\\user\\IdeaProjects\\java\\professional\\src\\main\\resources\\second\\io\\dataio.txt");
        wr.writeInt(file, 1023);
        //wr.writeString(file, "Hello");
    }
}

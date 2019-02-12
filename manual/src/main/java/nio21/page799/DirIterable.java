package nio21.page799;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class DirIterable {
    public static void main(String[] args) {
        DirIterable d = new DirIterable();
        d.recursionDir("io13");
    }


        public void recursionDir(String str) {
        try(DirectoryStream d = Files.newDirectoryStream(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\" + str))) {
            Iterator iterator = d.iterator();
            while (iterator.hasNext()) {
                Path o = (Path)iterator.next();
                if (Files.isDirectory(o)) {
                    recursionDir(o.getFileName().toString());
                    //System.out.println(o.getFileName());
                } else {
                    System.out.println(o.getFileName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

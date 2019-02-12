package nio21.p801;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirList {
    public static void main(String[] args) {
        DirList dirList = new DirList();
        dirList.rec("C:\\Users\\user\\");
    }
    public void rec(String d) {
        String dir = d;

        // Фильтр
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isWritable(entry);
            }
        };
        try(DirectoryStream<Path> str = Files.newDirectoryStream(Paths.get(dir), how)) {
            for (Path p : str) {
                if (Files.isDirectory(p)) {
                    System.out.println(p.toString());
                    rec(p.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

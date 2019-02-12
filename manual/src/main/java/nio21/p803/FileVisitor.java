package nio21.p803;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Обход дерева каталогов
 */
public class FileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }

    public static void main(String[] args) {
        String dir = "C:\\Users\\user\\IdeaProjects\\java\\manual";
        try {
            Files.walkFileTree(Paths.get(dir), new FileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

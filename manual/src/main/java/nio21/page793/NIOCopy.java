package nio21.page793;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NIOCopy {

    public static void main(String[] args) {
        args = new String[2];
        args[0] = "C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page793\\NIOCopy.java";
        args[1] = "C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page793\\out.txt";
        if (args.length < 2) {
            System.out.println("Ввведите 2 агрумента");
        }
        try {
            Path in = Paths.get(args[0]);
            Path out = Paths.get(args[1]);

            // копируем файл
            Files.copy(in, out, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package nio21.page794;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShowFile {
    public static void main(String[] args) {
        int i;

        // количество вызовов цикла
        int value = 0;

        // Открыть файл и связать с ним поток ввода-вывода
        try(InputStream f = Files.newInputStream(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page794\\ShowFile.java"));

            // Добавил BufferedOutputStream
            OutputStream o = new BufferedOutputStream(Files.newOutputStream(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page794\\out.txt")))){
            int code;
            while ((code = f.read()) != -1) {
                value++;
                o.write(code);
            }
            System.out.println("Количество вызовов цикла = " + value);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

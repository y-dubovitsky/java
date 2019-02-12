package nio21.page788;

import java.io.File;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {
    static File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page788\\MappedChannelRead.java");
    public static void main(String[] args) {
        try(FileChannel f = (FileChannel)Files.newByteChannel(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page788\\MappedChannelRead.java"))) {

            // размер файла
            long size = f.size();

            // сопоставляем файл с буффером
            MappedByteBuffer b = f.map(FileChannel.MapMode.READ_ONLY, 0, size);

            // читаем байты из буфера и выводим их на экран
            for(int i = 0; i < size; i++) {
                System.out.print((char)b.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package nio21.page790;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelWrite {
    public static void main(String[] args) {

        // Получаем канал к файлу
        try(FileChannel f = (FileChannel)Files.newByteChannel(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page790\\out.txt"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {

            // создаем буффер
            ByteBuffer b = ByteBuffer.allocate(100);

            // Записываем байты в буффер
            for (int i = 0; i < 20; i++) {
                b.put((byte)('A' + i));
            }

            // Подготовить буффер к записи ??????
            b.rewind();

            f.write(b);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package nio21.page792;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelMapWriteToFile {
    public static void main(String[] args) {
        try(FileChannel f = (FileChannel) Files.newByteChannel(Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page792\\out.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.READ,
                StandardOpenOption.CREATE)) {

            // Размер буфера.
            int size = 26;

            // Сопоставляем файл с буффером.
            MappedByteBuffer m = f.map(FileChannel.MapMode.READ_WRITE, 0, size);

            // Записать заданное количество байт в буффер (size)
            for (int i = 0; i < size; i++) {

                // так как у нас уже файл сопоставлен с буффер то запись идет автоматически при изменения буффера.
                m.put((byte) ('a' + i));
            }

            // Переводим указатель в буффере на начальную позицию и записываем в буфер значение А
            m.rewind();
            m.put((byte)'A');

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

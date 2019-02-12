package nio21.page785;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FromFileChannel {
    public static void main(String[] args) {
        int count;
        Path filepath = null;

        try {
            filepath = Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\nio21\\page785\\text.txt");
        } catch (InvalidPathException e) {
            e.printStackTrace();
        }
        // Получаем канал к файлу
        try(SeekableByteChannel s = Files.newByteChannel(filepath)) {
            // Выделяем память под буфер
            ByteBuffer byteBuffer = ByteBuffer.allocate(180); // Размер буффера

            do {
                // Читаем данные из файла в буффер
                count = s.read(byteBuffer); // Возвращает количество прочитанных байт
                if (count != -1) {
                    byteBuffer.rewind(); // ?? Подготовить буффер к чтению ИЗ НЕГО байт
                    for (int i = 0; i < count; i++) {
                        System.out.print((char)byteBuffer.get());
                    }
                }
            } while (count != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

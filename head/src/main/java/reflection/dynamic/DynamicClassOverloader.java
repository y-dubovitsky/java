package reflection.dynamic;

import java.io.*;

/**
 * При реализации пользовательских загрузчиков важно помнить следующее:
 * 1) любой загрузчик должен явно или неявно расширять класс java.lang.ClassLoader;
 * 2) любой загрузчик должен поддерживать модель делегирования загрузки, образуя иерархию;
 * 3) в классе java.lang.ClassLoader уже реализован метод непосредственной загрузки — defineClass(...),
 * который байт-код преобразует в java.lang.Class, осуществляя его валидацию;
 * 4) механизм рекурентного поиска также реализован в классе java.lang.ClassLoader и заботиться об это не нужно;
 * 5) для корректной реализации загрузчика достаточно лишь переопределить метод findClass() класса java.lang.ClassLoader.
 */
public class DynamicClassOverloader extends ClassLoader {

    // Path to file class
    String path;

    DynamicClassOverloader(String path, ClassLoader parent) {
        super(parent);
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException{
        try {
            /**
             * Получем байт-код из файла и загружаем класс в рантайм
             */
            byte b[] = fromFileToByteArray(path + className + ".class");
            /**
             * специальный «магический» метод defineClass:
             *
             * protected final Class defineClass(String name, byte[] b, int off, int len) throws ClassFormatError;
             * Это как раз то самое место, где цепочка байтов – образ .class-файла
             * (фрагмент массива b длины len по смещению off) – «чудесным образом» превращается в готовый к использованию класс.
             * Метод defineClass, как и следовало ожидать, реализован в native-коде.
             * Именно он помещает байт-код класса в недра виртуальной машины, где он приобретает вид,
             * пригодный для непосредственного исполнения на конкретной аппаратной платформе,
             * в частности, компилируется в машинный код процессора для более быстрого исполнения
             * (так называемая технология Just-In-Time, сокращенно JIT-компиляция).
             */
            return defineClass(className, b, 0, b.length);
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        }
    }

    /**
     * This method read file and transfer all data from file to byte array;
     * @param path
     * @return
     * @throws FileNotFoundException
     */
    private byte[] fromFileToByteArray(String path) throws FileNotFoundException {
        File file = new File(path);
        byte[] result = new byte[(int)file.length() + 100]; // just in case
        // checking; if file size > 0
        if (!(file.length() > 0) || file.length() > Long.MAX_VALUE) {
            throw new FileNotFoundException();
        }
        try(FileInputStream f = new FileInputStream(file)) {
            f.read(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

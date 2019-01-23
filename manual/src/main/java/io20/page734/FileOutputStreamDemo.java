package io20.page734;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {
        String in = "public class Foo {\n" +
                "    public static void main(String[] args) {\n" +
                "        new Thread(Foo::foo).start();\n" +
                "        new Thread(() -> bar()).start();\n" +
                "        new Thread(new Runnable() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                baz();\n" +
                "            }\n" +
                "        }).start();\n" +
                "    }\n" +
                "\n" +
                "    static void foo() { /* долгая задача 1 */ }\n" +
                "    static void bar() { /* долгая задача 2 */ }\n" +
                "    static void baz() { /* долгая задача 3 */ }\n" +
                "}";
        byte[] bytes = in.getBytes();
        System.out.println("Длина строки = " + in.length() +
                " Длина массива байт = " + bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i]);
        }
        int count = 0;
        try(FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\page734\\output.txt")) {
            for (int i = 0; i < bytes.length; i += 2) {
                fileOutputStream.write(bytes); // Записывает в файл весь текст count раз!!
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("Количество вызовов метода fileOutputStream.write(bytes) = " + count);
        }
    }
}

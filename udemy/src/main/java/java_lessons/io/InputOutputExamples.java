package java_lessons.io;

import java.io.*;

public class InputOutputExamples {

    /**
     * Можно читать и любые файлы! Даже картинки
     */
    private static File file = new File("udemy/src/main/resources/java_lessons/file.txt");
    private static File image = new File("udemy/src/main/resources/java_lessons/img.jpg");

    public static void reader(File file) throws Exception{
        Reader reader = new FileReader(file);
        int i = 0;
        while ((i = reader.read()) != -1) {
            System.out.println(i);
        }
    }

    public static void writer(File file) throws Exception {
        Writer writer = new FileWriter(file);
        writer.write(45);
        writer.write(10); // код символа пробела
        writer.write(46);
        writer.flush();
        writer.close();
    }

    /**
     * Фишка в том, что данные читаются из бефера то есть не нужно постоянно обращаться к источнику(файлу)
     * @param file
     * @throws Exception
     */
    public static void bufferedReader(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }
    }

    public static void bufferedWriter(File file) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Hello");
        bw.write("\n\r");
        bw.write("My friend");
        bw.close();
    }

    public static void main(String[] args) throws Exception{
        writer(file);
        reader(file);
        bufferedReader(file);
        bufferedWriter(file);
    }
}

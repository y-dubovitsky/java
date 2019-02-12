package io20.symbol.page767;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * в данной программе создается поток вывода типа FileOutputStream, ссылающийся на файл по имени " serial " , а для него - поток вывода
 * типа Obj ectOutputStream. Затем дя сериаизации объект вызывается метод
 * writeObj ect ( ) из касса Obj ectOutputStream. По завершении данного процесса очищается и закрывается поток вывода объектов.
 * Даее создается поток ввода типа F i l e i nput S t ream, ссылающийся на файл
 * по имени " serial " , а для него - поток ввода типа Obj e c t i nput Stream. Для последющей десериаизации объект вызывается метод readObj ect ( ) из касса
 * Obj ect inputSt ream.
 */
public class SerializeShow {

    File file = new File("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\symbol\\page767\\file");

    public void doSerialize() {
        try(ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            MyClass myClass = new MyClass(1, "Hello World", 0.45);
            o.writeObject(myClass); // Записываем объект в файл со значениями его полей
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doUnserialize() {
        try(ObjectInputStream i = new ObjectInputStream(new FileInputStream(file))) {
            MyClass myClass = (MyClass) i.readObject();
            System.out.println(myClass.toString());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args)  throws URISyntaxException {
        SerializeShow s = new SerializeShow();
        s.doSerialize();
        s.doUnserialize();
        // Просто так добавил
        Path path = Paths.get("C:\\Users\\user\\IdeaProjects\\java\\manual\\src\\main\\java\\io20\\symbol\\page767\\SerializeShow.java");
        System.out.println(path.getFileName());
//        Path path1 = Paths.get(new URI("io20.symbol.page767.SerializeShow"));
//        System.out.println(path1.getFileName());
    }

    /**
     * Класс, объекты которого будут сериализовываться.
     */
    static class MyClass implements Serializable {
        int a;
        transient String str; // это поле не будет сериализовано!
        double d;

        public MyClass(int a, String str, double d) {
            this.a = a;
            this.str = str;
            this.d = d;
        }

        @Override
        public String toString() {
            return "a = " + a + " str = " + str + " d = " + d;
        }
    }
}

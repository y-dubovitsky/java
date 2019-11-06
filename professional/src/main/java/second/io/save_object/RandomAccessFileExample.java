package second.io.save_object;

import second.io.save_object.Employee;

import java.io.*;
import java.util.Date;

//TODO Дописать класс!
public class RandomAccessFileExample {

    private static final File FILE = new File("professional/src/main/resources/second/io/employers.txt");

    private static void writeEmployee(DataOutput writer, Employee e) {
        try {
            writer.write(e.getWage());
        } catch (Exception er) {
            er.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Employee[] em = new Employee[]{
                new Employee("Matthey", 30, new Date().toString()),
                new Employee("Antilis", 30, new Date().toString()),
                new Employee("Zucher", 30, new Date().toString())
        };

        try(DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE))) {
            for (int i = 0; i < em.length; i++) {
                writeEmployee(out, em[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

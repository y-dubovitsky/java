package second.io.serialize.simple_serialize;

import second.io.serialize.simple_serialize.entity.Employee;

import java.io.*;

/**
 * В этом классе показано, как сериализовать и десериализовать объекты.
 */
public class SerializeObject {

    private static File file = new File("professional/src/main/resources/second/io/serialize/objects.txt");

    /**
     * Сохранить объект в файл
     * @param employees
     */
    public void saveObject(Employee... employees) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(employees);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Десериализовать объекты из файла
     * @param file
     * @return
     */
    public Employee[] readObject(File file) {
        Employee[] employees = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            employees = (Employee[]) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        } finally {
            return employees;
        }
    }

    public static void main(String[] args) {
        SerializeObject s = new SerializeObject();
        s.saveObject(new Employee("Matthey", 30_000, 1995));
        Employee[] employees = s.readObject(file);
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
}

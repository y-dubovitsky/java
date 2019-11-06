package second.io.serialize.version_control;

import java.io.*;

public class SerializeVersionControl {

    private static File file = new File("professional/src/main/resources/second/io/serialize/objects.txt");

    //TODO Fix it!
    // Задумка в чем, чтобы в аргументах метода был указан родительский класс, а передавался потомок
    // А потом уже сериализация
    public void saveObject(EmployeeOne employee) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(out);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Employee loadObject() {
        Employee employee = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            employee = (Employee)in.readObject();
        } catch (Exception i) {
            i.printStackTrace();
        } finally {
            return employee;
        }
    }

    public static void main(String[] args) {
        EmployeeOne one = new EmployeeOne("First");
        SerializeVersionControl s = new SerializeVersionControl();
        s.saveObject(one);
        EmployeeTwo two = (EmployeeTwo)s.loadObject();
    }

}

class Employee implements Serializable{

    public static final long serialVersionUID = -2814239825517340645L;

    public String name;

    public Employee(String name) {
        this.name = name;
    }
}

class EmployeeOne extends Employee implements Serializable {

    public EmployeeOne(String str) {
        super(str);
    }

}

class EmployeeTwo extends Employee implements Serializable {

    // Вычисляется только утилитой?
    public static final long serialVersionUID = -1814239825517340645L;

    public String name;
    public int age;

    public EmployeeTwo(String name, int age) {
        super(name);
        this.age = age;
    }

}

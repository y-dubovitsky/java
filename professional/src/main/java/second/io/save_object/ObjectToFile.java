package second.io.save_object;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

class Employee {

    private String name;
    private int wage;
    private String date;

    public Employee(String s, int w, String d) {
        this.name = s;
        this.wage = w;
        this.date = d;
    }

    public String getName() {
        return name;
    }

    public int getWage() {
        return wage;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return getName() + "|" + getWage() + "|" + getDate();
    }
}

public class ObjectToFile {

    private static final File FILE = new File("professional/src/main/resources/second/io/inputtext.txt");

    private static void writeEmployeeToFile(PrintWriter writer, Employee e) {
        writer.println(e.getName() + "|" + e.getWage() + "|" + e.getDate());
    }

    private static Employee getEmployeeFromFile(Scanner scanner) {
        String str = scanner.nextLine();
        String[] param = str.split("\\|");
        String name = param[0];
        int age = Integer.valueOf(param[1]);
        String date = param[2];
        Employee employee = new Employee(name, age, date);
        return employee;
    }

    public static void getAllEmployee(Scanner scanner) {
        while (scanner.hasNext()) {
            System.out.println(getEmployeeFromFile(scanner));
        }
    }

    public static void writeAllEmployee(Employee... employee) {
        try(PrintWriter writer = new PrintWriter(FILE)) {
            for (int i = 0; i < employee.length; i++)
            writeEmployeeToFile(writer, employee[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        Employee[] em = new Employee[]{
                new Employee("Matthey", 30, new Date().toString()),
                new Employee("Antilis", 30, new Date().toString()),
                new Employee("Zucher", 30, new Date().toString())
        };
        writeAllEmployee(em);
        Scanner scanner = new Scanner(FILE);
        getAllEmployee(scanner);
    }
}

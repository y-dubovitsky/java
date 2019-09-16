package first.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

/**
 * Employee in the firm;
 */
class Employee {

    String name;
    int id;
    private static Random rnd = new Random();

    public Employee(String name) {
        this.name = name;
        this.id = rnd.nextInt();
    }

    @Override
    public String toString() {
        return " id = " + id + " name = " + name;
    }
}

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Employee> map = new HashMap<>();
        Random random = new Random(47);
        map.put("First", new Employee("Matthey"));
        map.put("Second", new Employee("Antilis"));
        // foreach like a lambda
        map.forEach((a,b) -> {
            System.out.println(a + b);
        });
        // standard foreach
        for (Map.Entry<String, Employee> m : map.entrySet()) {
            System.out.println(m.getKey() + m.getValue());
        }
    }
}

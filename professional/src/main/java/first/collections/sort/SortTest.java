package first.collections.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Simple class with getter
 */
class Employee {
    private int id;

    public Employee(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return " " + id + " ";
    }
}

/**
 * Main class which shows how to use sort in the collections;
 */
public class SortTest {

    List<Employee> list;

    public SortTest(List<Employee> list) {
        this.list = list;
    }

    private List<Employee> sortList() {
        this.list.sort(Comparator.comparingInt(Employee::getId));
        return this.list;
    }

    private <T> void outputList(List<T> list) {
        list.stream()
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        SortTest sortTest = new SortTest(new ArrayList<>(){
            {
                add(new Employee(1));
                add(new Employee(45));
                add(new Employee(-5));
                add(new Employee(0));
            }});
        sortTest.outputList(sortTest.list);
        // sorting
        sortTest.sortList();
        // output
        sortTest.outputList(sortTest.list);
    }
}

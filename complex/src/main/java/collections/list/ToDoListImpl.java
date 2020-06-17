package collections.list;

import java.util.Iterator;
import java.util.List;

/**
 * To-Do List class
 */
public class ToDoListImpl<T> implements ToDoList{

    /**
     * List of tasks
     */
    List<String> list;

    public ToDoListImpl(List list) {
        this.list = list;
    }

    public boolean addTask(String task) {
        return list.add(task);
    }

    public void addTaskToPosition(String taks, int position) {
        list.add(position, taks);
    }

    public void printToDoList() {
        for (String s : this.list) {
            System.out.println(s);
        }
    }

    /**
     * Метод compareTo в Java сравнивает вызывающий объект с объектом, переданным в качестве параметра,
     * и возвращает в результате выполнения сравнения целое число:
     * положительное, если вызывающий объект больше объекта, переданного в качестве параметра;
     * отрицательное, если вызывающий объект меньше объекта, переданного в качестве параметра;
     * нуль, если объекты равны.
     * @param task
     */
    public void addAlphabeticalTask(String task) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.compareTo(task) == 0) {
                System.out.println("This task already exists");
            } else if(next.compareTo(task) < 0) {
                int i = list.indexOf(next);
                this.addTaskToPosition(task, i); // вставляется перед существующей задачей
            }
        }
        this.addTask(task);
    }

    public void changeTask(String newTask, int position) {
        this.list.set(position, newTask);
    }

    public void removeTask(String task) {
        this.list.remove(task);
    }

    public int getTaskIndex(String task) {
        return this.list.indexOf(task);
    }



}

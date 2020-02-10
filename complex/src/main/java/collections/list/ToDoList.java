package collections.list;

import java.util.List;

/**
 * To-Do List class
 */
public class ToDoList {

    /**
     * List of tasks
     */
    List<String> list;

    public ToDoList(List list) {
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

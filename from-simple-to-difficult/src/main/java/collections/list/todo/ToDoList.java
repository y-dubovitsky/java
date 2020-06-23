package collections.list.todo;

public interface ToDoList {


    boolean addTask(String task);

    void addTaskToPosition(String taks, int position);

    void printToDoList();

    void changeTask(String newTask, int position);

    void removeTask(String task);

    int getTaskIndex(String task);

}

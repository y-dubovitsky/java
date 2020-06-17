package collections.list;

public interface ToDoList {


    public boolean addTask(String task);

    public void addTaskToPosition(String taks, int position);

    public void printToDoList();

    public void changeTask(String newTask, int position);

    public void removeTask(String task);

    public int getTaskIndex(String task);

}

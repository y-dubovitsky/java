package collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListRunner {

    private Scanner scanner;
    private ToDoList toDoList;

    public ListRunner() {
        scanner = new Scanner(System.in);
        toDoList = new ToDoListImpl(new ListFactory<String>().getList("ArrayList"));
    }

    public static void main(String[] args) {
        ListRunner runner = new ListRunner();
        runner.start();
    }

    /**
     * Example of Exception in thread "main" java.util.NoSuchElementException
     */
    private static void iteraShow() {
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            li.add(i);
        }
        Iterator<Integer> iterator = li.iterator();
        for (int i = 0; i < 20; i++) {
            System.out.println(iterator.next()); //Exception in thread "main" java.util.NoSuchElementException
        }
    }

    private void start() {
        System.out.println(showMenu());
        int i = scanner.nextInt();
        while (inputValidation(i)) {
            i = scanner.nextInt();
        }
        while (i != 6) {
            switch (i) {
                case 0: {
                    System.out.println("addTask");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    toDoList.addTask(task);
                    break;
                }
                case 1: {
                    System.out.println("addTaskToPosition");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    scanner.nextInt();
                    int position = scanner.nextInt();
                    toDoList.addTaskToPosition(task, position);
                    break;
                }
                case 2: {
                    System.out.println("printToDoList");
                    toDoList.printToDoList();
                    break;
                }
                case 3: {
                    System.out.println("Please enter a new task");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    System.out.println("Please enter a new task index");
                    scanner.nextLine();
                    int position = scanner.nextInt();
                    toDoList.changeTask(task, position);
                    break;
                }
                case 4: {
                    System.out.println("removeTask");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    toDoList.removeTask(task);
                    break;
                }
                case 5: {
                    System.out.println("getTaskIndex");
                    scanner.nextLine();
                    String task = scanner.nextLine();
                    toDoList.getTaskIndex(task);
                    break;
                }
                case 6: {
                    showMenu();
                    break;
                }
                case 7: {
                    System.out.println("Exit");
                    break;
                }
            }
            System.out.println("Please make a choose : ");
            i = scanner.nextInt();
        }
    }

    private String showMenu() {
        String menu =
                "0. addTask " + System.lineSeparator() +
                "1. addTaskToPosition" + System.lineSeparator() +
                "2. printToDoList" + System.lineSeparator() +
                "3. changeTask" + System.lineSeparator() +
                "4. removeTask" + System.lineSeparator() +
                "5. getTaskIndex" + System.lineSeparator() +
                "6. Show menu " + System.lineSeparator() +
                "7. Exit"
                ;
        return menu;
    }

    private boolean inputValidation(int i) {
        boolean flag = true;
        if (i >= 0 && i <=7 ) {
            System.out.println("Please enter correct value");
            flag = false;
        }
        return flag;
    }

}

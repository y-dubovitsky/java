package main.java.javaLang17.page524;

public class ExecDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        Process process;
        try {
            process = runtime.exec("Notepad");
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}

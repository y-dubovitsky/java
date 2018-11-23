package main.java.javaLang17.page522;

import java.io.IOException;

public class RuntimeShow {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("C:\\Program Files\\Notepad++\\notepad++.exe");
        NewThread newThread = new NewThread();
        // Регистрируем поток
        runtime.addShutdownHook(newThread);
        //newThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " главный поток работает");
            if (i == 5) {
                //runtime.halt(1234);
            }
            Thread.sleep(1000);
        }
        // Прерываем работу работу JVM
        //runtime.halt(1234);
        System.out.println(process.isAlive());
        Thread.sleep(1000);
        System.out.println(process.isAlive());
        // Что мы еще можем сделать с новым процессом?
        process.destroy(); // Уничтожили процесс
        // А с RunTime что?
        System.out.println(runtime.freeMemory());
    }
}

class NewThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

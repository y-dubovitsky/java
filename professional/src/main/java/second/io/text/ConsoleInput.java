package second.io.text;

import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {

    /**
     * В этом методе строки посимвольно считываются с консоли
     */
    public void consoleRead() {
        Runnable runnable = () -> {
            InputStreamReader is = new InputStreamReader(System.in);
            try {
                while (true) {
                    // is.read - читает кодовую единицу
                    // потом кодовая единица преобразуется в символ по Юникоду
                    System.out.print((char)is.read());
                }
            } catch (IOException i) {
                i.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public static void main(String[] args) {
        new ConsoleInput().consoleRead();
    }
}

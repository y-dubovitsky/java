package second.io.text;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class ConsoleReader{

    private InputStream input;
    private int count = 0;
    ArrayList<String> list = new ArrayList<>();
    private static File file = new File("professional/src/main/resources/second/io/file_filter/numbers.txt");

    public ConsoleReader(InputStream is) {
        this.input = is;
    }

    /**
     * Этот метод использет общий ресур но для чтения!
     * Берет из списка значение и записывает его в файл.
     * @param file
     */
    public void writeToFile(File file) {
        try{
            OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file));
            while (true) {
                if (list.size() > 0) {
                    writer.write(list.get(count));
                    count++;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException i) {
                        i.printStackTrace();
                    }
                }
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method runs one more else thread! This method add into list String from UserInput;
     * //TODO Нужно додумать, так как много слов подряд записывает!
     * @param is
     */
    public void getString(InputStream is) {
        Scanner scanner = new Scanner(is);
        Runnable runnable = () -> {
            while (true) {
                String str = scanner.nextLine();
                list.add(str);
                try{
                    Thread.sleep(10000);
                } catch (InterruptedException i) {
                    i.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader(System.in);
        consoleReader.getString(consoleReader.input);
        consoleReader.writeToFile(file);
    }
}

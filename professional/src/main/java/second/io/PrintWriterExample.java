package second.io;

import java.io.File;
import java.io.PrintWriter;

public class PrintWriterExample {

    private final static File FILE = new File("professional/src/main/resources/second/io/printwriterexample.txt");
    private final static String STRING = "JDBC (Java Database Connectivity) – " +
            "это технология, которая обеспечивает доступ " +
            "Java API к реляционным базам данных. Благодаря " +
            "этому, наши Java-приложения могут выполнять " +
            "SQL-запросы и взаимодействовать с базами данных (далее – БД), " +
            "котрые поддерживают SQL.";

    /**
     * Write to file array of char
     * @param array
     */
    public void writeToFile(char[] array) {
        try(PrintWriter writer = new PrintWriter(FILE,"UTF-8")) {
            writer.write(array);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print to output stream(file)
     * @param str
     */
    public void printToFile(String str) {
        try(PrintWriter writer = new PrintWriter(FILE)) {
            writer.print(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PrintWriterExample p = new PrintWriterExample();
        p.writeToFile(STRING.toCharArray());
        p.printToFile("Hello, this is string");
    }
}

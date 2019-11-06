package second.io.text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class TextToFileOutput {
    private static final File FILE = new File("professional/src/main/resources/second/io/dataio.txt");

    /**
     * В этом методе используется PrintWriter, т.е. все символы в таком же виде в файл и выводятся
     */
    public void writeText() {
        try(PrintWriter writer = new PrintWriter(FILE, Charset.defaultCharset())) {
            for (int i = 0; i < 10; i++) {
                writer.print(i);
            }
            Desktop.getDesktop().open(FILE);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Записывает символы как набор байтов
     */
    public void writeBytes() {
        try(PrintStream ps = new PrintStream(FILE, Charset.defaultCharset())) {
            for (int i = 0; i < 10; i++) {
                ps.write(i);
            }
            Desktop.getDesktop().open(FILE);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TextToFileOutput().writeText();
        new TextToFileOutput().writeBytes();
    }
}

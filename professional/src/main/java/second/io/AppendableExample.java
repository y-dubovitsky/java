package second.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class AppendableExample {

    private Writer writer;

    public AppendableExample(Writer writer) {
        this.writer = writer;
    }

    /**
     * This method add to the end of file a symbol;
     * @param c - users symbol
     * @throws IOException
     */
    public void addCharToInput(char c) throws IOException {
        try {
            writer.append(c);
        } catch (IOException i) {
            i.printStackTrace();
        } finally {
            writer.close();
        }
    }

    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter("professional/src/main/resources/second/io/dataio.txt");
        writer.write("hello my friend!");
        AppendableExample a = new AppendableExample(writer);
        a.addCharToInput('a');
    }
}

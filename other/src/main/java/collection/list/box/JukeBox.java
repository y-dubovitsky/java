package collection.list.box;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * In this class all data from this class splitting by "splitter" and
 * writing to list;
 */
public class JukeBox {

    private List<String> list;

    public JukeBox() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return this.list;
    }

    public static void main(String[] args) {
        JukeBox jukeBox = new JukeBox();
        jukeBox.starting(
                "C:\\Users\\user\\IdeaProjects\\java\\other\\src\\main\\java\\collection\\list\\box\\JuewqkeBox.java",
                "}"
        );
        System.out.println(jukeBox.getList());
    }

    public void starting(String file, String splitter) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String locStr;

            //TODO Читает строку, а нужно чтобы читал символы пока не найдет сплиттер!
            while ((locStr = br.readLine()) != null) {

                // invoke another method
                arrayToList(locStr.split(splitter));
            }
        } catch (FileNotFoundException f) {
            ClassLoader loader = this.getClass().getClassLoader();
            String localFile = Objects.requireNonNull(loader.getResource("text.txt")).getFile();
            // так наверное нельзя! бесконечный цикл будет
            starting(localFile, splitter);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * From array to list;
     * @param str - array
     */
    private void arrayToList(String[] str) {
        this.list.addAll(Arrays.asList(str));
    }
}

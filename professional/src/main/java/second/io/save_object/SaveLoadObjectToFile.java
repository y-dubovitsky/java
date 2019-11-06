package second.io.save_object;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class SaveLoadObjectToFile {

    private static final String SEPARATOR = "|";
    private static File file;

    /**
     * Create a singleton file;
     * @param path - path
     * @return
     */
    public static File generateFile(String path) {
        try {
            if (file == null) {
                file = new File(path, "objects.txt");
                file.createNewFile();
            } else {
                return file;
            }
        }catch(IOException i){
            i.printStackTrace();
        } finally{
            return file;
        }
    }

    /**
     * Save object to file
     * @param file
     * @param instances
     */
    public void saveObject(File file, Instance... instances) {
        try(PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < instances.length; i++) {
                writer.print(instances[i].getName() + SEPARATOR + instances[i].getValue());
                writer.println();
            }
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Get all objects from file!
     * @param file
     * @return
     */
    public List<Instance> getObject(File file) {
        List<Instance> list = new ArrayList<>();
        try(Stream<String> stream = new BufferedReader(new InputStreamReader(new FileInputStream(file))).lines()) {
            stream.forEach((str) -> {
                String[] variables = str.split("\\" + SEPARATOR);
                Instance instance = new Instance(variables[0], Integer.parseInt(variables[1]));
                list.add(instance);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return list;
        }
    }

    public static void main(String[] args) {
        SaveLoadObjectToFile s = new SaveLoadObjectToFile();
        Instance[] in = new Instance[2];
        in[0] = new Instance("First", 1);
        in[1] = new Instance("Second", 2);
        s.saveObject(generateFile("professional/target/classes/second/io/"), in);
        // Тут просто файл перезапишется!
        //s.saveObject(generateFile("professional/target/classes/second/io/"), new Instance("new Object", 12421515));
        List<Instance> instances = s.getObject(file);
        Iterator<Instance> iterator = instances.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

/**
 * Simple class with fields
 */
class Instance {

    String name;
    int value;

    public Instance(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getValue();
    }
}

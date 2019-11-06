package second.io.serialize.simple_serialize;

import second.io.serialize.simple_serialize.entity.Manager;
import second.io.serialize.simple_serialize.entity.Secretary;
import second.io.serialize.simple_serialize.entity.Worker;

import java.io.*;

public class ObjectStreamTest {

    private static File file = new File("professional/src/main/resources/second/io/serialize/objects.txt");

    /**
     * Save objects
     * @param worker
     */
    public void saveObjects(Worker... worker) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(worker);
        }catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * Load objects
     * @param file
     * @return
     */
    public Worker[] loadObjects(File file) {
        Worker[] workers = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            workers = (Worker[]) in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        } finally {
            return workers;
        }
    }

    public static void main(String[] args) {
        Manager manager1 = new Manager("Manager", new Secretary("Secretary", 30_000, 1978), 1_000, 1899);
        Manager manager2 = new Manager("Manager", new Secretary("Secretary", 30_000, 1978), 1_000, 1899);
        ObjectStreamTest o = new ObjectStreamTest();
        // array of managers
        Manager[] managers = new Manager[]{manager1, manager2};
        o.saveObjects(managers);
    }
}

package second.io.serialize.simple_serialize;

import java.io.*;

/**
 * Смотри пример из Библиотеки проффесионала страница 106!
 */
public class RedefineSerialize {

    private static File file = new File("professional/src/main/resources/second/io/serialize/objects.txt");

    public void saveObject(Human human, File file) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(human);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public Human loadObject(File file) {
        Human human = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            human = (Human)in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        } finally {
            return human;
        }
    }

    public void soutObject(Human human) {
        System.out.println("Human name " + human.getName() + " Arm " + human.getArm());
    }

    public static void main(String[] args) {
        Human human = new Human("Antilis Aton", new Arm(1, 2));
        RedefineSerialize r = new RedefineSerialize();
        r.saveObject(human, file);
        Human newHuman = r.loadObject(file);
        r.soutObject(newHuman);
    }
}

class Human implements Serializable {

    private String name;
    private transient Arm arm;


    public Human(String name, Arm arm) {
        this.name = name;
        this.arm = arm;
    }

    private void readObject(ObjectInputStream in) throws Exception{
        in.defaultReadObject();
        int hand = in.readInt();
        int head = in.readInt();
        arm = new Arm(hand, head);
    }

    private void writeObject(ObjectOutputStream out) throws Exception{
        out.defaultWriteObject();
        out.writeObject(arm.getHand());
        out.writeObject(arm.getHead());
    }

    public String getName() {
        return name;
    }

    public Arm getArm() {
        return arm;
    }
}

class Arm {

    private int hand;
    private int head;

    public Arm(int hand, int head) {
        this.hand = hand;
        this.head = head;
    }

    @Override
    public String toString() {
        return this.head + " " + this.hand;
    }

    public int getHand() {
        return hand;
    }

    public int getHead() {
        return head;
    }
}

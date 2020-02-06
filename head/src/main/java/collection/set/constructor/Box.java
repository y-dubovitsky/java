package collection.set.constructor;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class must show, how to use non default constructor when object created.
 */
public class Box {

    // Attention! When create new object set, invoke non default constructor!!!
    Set<Thing> setComparator = new TreeSet<>(new Comparator<Thing>() {
        @Override
        public int compare(Thing o1, Thing o2) {
            return Integer.compare(o1.age, o2.age);
        }
    });

    Set<Thing> setComparable = new TreeSet<>();

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Box box = new Box();
        box.fillSet(box.setComparator, "names.txt");
        box.fillSet(box.setComparable, "names.txt");
        box.sout(box.setComparable);
        System.out.println(" ####################### ");
        //TODO Это множество не заполняется!
        box.sout(box.setComparator);
    }

    /**
     * Output all names of Input objects;
     * @param set
     */
    private void sout(Set<? extends Thing> set) {
        Iterator iterator = set.iterator();
        System.out.println("HashCode = " + set.hashCode());
        while (iterator.hasNext()) {
            Thing t = (Thing)iterator.next();
            System.out.println(t.name);
        }
    }

    /**
     * This method fills a input set of objects.
     * @param set - input set
     * @param path - file
     * @return
     */
    protected Set fillSet(Set set, String path) {
        File file = new File(this.getClass().getClassLoader().getResource(path).getPath());
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name;
            while ((name = br.readLine()) != null) {
                set.add(new Thing(name, (int)Math.random() * 100));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }

    /**
     * Inner class
     */
    class Thing implements Comparable<Thing>{

        private String name;
        private int age;

        public Thing(String name, int a) {
            this.age = a;
            this.name = name;
        }

        @Override
        public int compareTo(@NotNull Thing o) {
            return this.name.compareTo(o.name);
        }
    }
}

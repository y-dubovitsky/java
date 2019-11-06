package collectoins;

import java.util.*;

public class AddingGroup {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        Integer[] integers = {8,9,10,11};
        collection.addAll(Arrays.asList(integers));
        //
        Collections.addAll(collection, 15,15,15,18);
        Collections.addAll(collection, integers);
        //
        try {
            List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
            list.add(10);
        } catch (UnsupportedOperationException u) {
            System.out.println("I cant add more values into fixed array");
        }
        //
        List<Integer> l = new ArrayList<>();
        l.add(14);
        l.add(535);
    }
}

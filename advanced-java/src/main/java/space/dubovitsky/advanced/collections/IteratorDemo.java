package space.dubovitsky.advanced.collections;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorDemo {

    private  LinkedList<Integer> list = new LinkedList<>(); //! LinkedList

    public static void main(String[] args) {
        IteratorDemo demo = new IteratorDemo();

        LinkedList<Integer> integers = demo.fillList(demo.list);

        demo.removeFromForEach(integers);

        demo.removeFromIterator(integers);

    }

    //* Никак не получается удалить из коллекции без ConcurrentModificationException
    private void removeFromForEach(LinkedList<Integer> list) {

        System.out.println("removeFromForEach - " + list);

        for (Integer value:
                list) {

            //! Exception in thread "main" java.util.ConcurrentModificationException
            //list.remove(5);
            if (value == 5) {
                list.remove(list.getFirst());
            }

        }

        System.out.println("removeFromForEach - " + list);

    }

    private void removeFromIterator(LinkedList<Integer> list) {

        System.out.println("removeFromIterator - " + list);

        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {

            Integer next = iterator.next();
            if (next == 5) {
                iterator.remove();
                System.out.println("Removed");
            }
        }

        System.out.println("removeFromIterator - " + list);
    }

    private LinkedList<Integer> fillList(LinkedList<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        return list;
    }

}

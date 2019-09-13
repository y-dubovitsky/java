package first.collections.add;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class LinkList {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        Stream.of("1","2","3","4")
                .forEach(x -> list.add(x));

        ListIterator<String> i1 = list.listIterator();
        ListIterator<String> i2 = list.listIterator();
        i1.next();
        i2.next();
        //i1.remove(); error
        i2.next();
    }
}

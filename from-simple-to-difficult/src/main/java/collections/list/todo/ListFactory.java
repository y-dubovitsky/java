package collections.list.todo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListFactory<T> {

    private List<T> list;

    public ListFactory() {

    }

    public List getList(String type) {
        if (type.equals("ArrayList")) {
            list = new ArrayList<>();
            return list;
        }
        if (type.equals("LinkedList")) {
            list = new LinkedList<>();
        }
        return list;
    }

}

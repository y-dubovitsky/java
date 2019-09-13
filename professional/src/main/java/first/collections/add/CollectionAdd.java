package first.collections.add;

import java.util.ArrayList;
import java.util.List;

class Clazz {
}

public class CollectionAdd {

    /**
     * Just a simple generic method
     * @param t
     * @param <T>
     * @return
     */
    public <T> T getT(T t) {
        return t;
    }

    public static void main(String[] args) {
        Clazz clazz = new Clazz();
        List<Clazz> list = new ArrayList<>();
        System.out.println("list size before add same objects = " + list.size());
        for (int i = 0; i < 10; i++) {
            list.add(clazz);
        }
        System.out.println("after = " + list.size());
    }
}

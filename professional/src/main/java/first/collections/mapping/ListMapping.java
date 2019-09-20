package first.collections.mapping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * This class show how to use mapping;
 */
public class ListMapping<T extends Integer> {

    private static Integer[] array = new Integer[]{1,2,33,-4,5,-6,7,8,9,0};

    private List<T> arrayToList(T[] array) {
        return Arrays.asList(array);
    }

    private List<T> getSublist(List<T> list, int a, int b) {
        return list.subList(a,b);
    }

    private void outputCollection(List<T> list) {
        list.stream()
                .sorted(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 > o2 ? 1 : (o1 == o2 ? 0 : -1);
                    }
                })
                .forEach(System.out::print);
    }

    /**
     * Remove from List every second element;
     */
    public List<T> removeWithIterator(List<T> list) {
        List<T> localList = list;
        Iterator<T> iterator = localList.iterator();
        try {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return localList;
        }
    }

    public static void main(String[] args) {

    }
}

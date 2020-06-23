package collections.list.converter;

import java.util.*;

public class CollectionConverter {

    private static Integer[] array = {1,2,3,4,5,6,7,8,9,0};
    private static List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,4,5,6,7,8,8,9));


    public static void main(String[] args) {
        arrayToListConvert(array);
    }

    /**
     * Важно! Массив в List
     * @param array
     */
    private static List<Integer> arrayToListConvert(Integer[] array) {
        List<Integer> integers = Arrays.asList(array); // Внимание! Тут создается Лист фикс. длины
        System.out.println(integers);
        array[0] = 23123;
        System.out.println(integers); //! меняется и integers
        List<Integer> list = new ArrayList<>(integers);
        list.add(123);
        return list;
    }

    /**
     * List to the array
     * @param list
     * @param arraySize
     * @return
     */
    private static Integer[] ListToArrayConvert(List<Integer> list, int arraySize) {
        Integer[] ints = new Integer[arraySize];
        ints = list.toArray(new Integer[arraySize]);
        return ints;
    }

}

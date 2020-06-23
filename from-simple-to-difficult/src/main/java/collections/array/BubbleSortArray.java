package collections.array;

import java.util.Comparator;

/**
 * This class demonstrates the use of bubble sorting.
 */
class BubbleSortArray {

    private static Integer[] array = {5,6,1,9,12,44,-1,0};
    private static String[] strArray = {"Миша", "a", "354", "@", "bc", "wr", "Hello", "Алексей"};

    public static void main(String[] args) {
        //* Integer sort
        BubbleSortArray bs = new BubbleSortArray();
        array = bs.sortedArray(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return (x < y) ? -1 : ((x == y) ? 0 : 1);
            }
        });
        bs.printArray(array);
        //* String sort
        strArray = bs.sortedArray(strArray, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        bs.printArray(strArray);
    }

    /**
     * A generic method that sorts an input array
     * @param array
     * @param comparator - T comparator
     * @param <T>
     * @return
     */
    private <T> T[] sortedArray(T[] array, Comparator<T> comparator) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1; j++) {
                if(comparator.compare(array[j], array[j+1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        return array;
    }

    /**
     * Outputs an input array
     */
    private <T> void printArray(T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }
    }
}

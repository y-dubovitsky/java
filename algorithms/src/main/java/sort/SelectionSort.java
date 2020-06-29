package sort;

import java.util.Arrays;

/**
 * Сортировка выбором
 */
class SelectionSort {

    private static final int[] INPUT_ARRAY = {-5, -1, 234, 0, 234, 51, 4325, 543, -99999};

    public static void main(String[] args) {
        Arrays.stream(new SelectionSort().sortBySelection(INPUT_ARRAY))
                .forEach(System.out::println);
    }

    private int[] sortBySelection(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minElementIndex = findMinElementIndex(array, i, false);
            int temp = array[minElementIndex];
            array[minElementIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * Метод возвращает индекс минимального элемента в массиве, начиная с индекса - start.
     */
    private int findMinElementIndex(int[] array, int start, boolean flag) {
        int index = start;
        if (flag) System.out.println("Длина массива = " + (array.length - start)); //! Просто для наглядности
        for (int i = start; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                index = i + 1;
            }
        }
        return index;
    }

}

package sort;

import java.util.Arrays;

/**
 * Сортировка пузырьком
 */
class BubbleSort {

    private static final int[] INPUT_ARRAY = {-5, 234, 0, 234, 51, 4325, 543, -99999};

    public static void main(String[] args) {
        new BubbleSort().bubbleSort(INPUT_ARRAY);
    }

    private void bubbleSort(int[] array) {
        boolean flag = false; //* Флаг для ограничения количества итераций
        while (!flag) {
            flag = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) { //* Если условие не отработало ни разу, значит сортировать нечего
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    flag = false;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

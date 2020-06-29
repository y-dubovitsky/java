package search;

/**
 * Поиск минимального элемента в массиве.
 */
class MinElementSearch { //TODO Можно улучшить, сделать дженерик и т.п.

    private static final int[] INPUT_ARRAY = {1,5,-567, 34, 545, 654, 023, 234};

    public static void main(String[] args) {
        new MinElementSearch().minElementSearch(INPUT_ARRAY);
    }

    private int minElementSearch(int[] array) {
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        System.out.println("Min element = " + min + " index : " + index);
        return min;
    }

}

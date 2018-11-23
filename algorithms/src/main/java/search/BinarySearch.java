package search;

/**
 * Класс реализующий алгоритм Бинарного поиска.
 */
public class BinarySearch {

    /**
     * @param array - отсортированный массив.
     * @param element - искомый элемент.
     * @return - индекс искомого элемента.
     * @throws InterruptedException
     */
    public int search(Integer[] array, int element) throws InterruptedException {
        int result = 0;
        boolean end = false;
        int min = 0;
        int max = array.length - 1;
        while (!end) {
            Thread.sleep(1000);
            int mid = (min + max) / 2;
            int guest = array[mid];
            if (guest == element) {
                result = mid;
                end = true;
            }
            if (guest > element) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
}

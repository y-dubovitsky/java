package collections.array;

import java.security.SecureRandom;
import java.util.*;

/**
 *  arr[0][0], arr[0][1], arr[0][0]
 *  arr[1][1], arr[1][2], arr[1][3]
 *  arr[2][0], arr[2][1], arr[2][2]
 */
class MultidimensionalArray {

    private SecureRandom random = new SecureRandom();
    private String[] strArray = {"a", "b", "123", "f5", "Маким"};
    private Integer[][] doubleIntArray = {
            {0,0}, // a[0]
            {1,0}, // a[1]
            {2,0,3,4,5} //* a[2] = {2,0,3,4,5}
    };
    private String[][] doubleStrArray = {
            {"0","035"}, // a[0]
            {"tgg1","0", "%:%№"}, // a[1]
    };

    public static void main(String[] args) {
        MultidimensionalArray m = new MultidimensionalArray();
        m.bonesDropEmulation();
        m.twoDimensionalArrGenerate();
        m.forEachDoubleArray(m.doubleIntArray);
        m.forEachDoubleArray(m.doubleStrArray);
        System.out.println("Minimum value = " + m.getMinArrayValue(m.doubleIntArray));
    }

    /**
     * This method shows how work with double-dimension array;
     * arr[0][0], arr[0][1], arr[0][0]
     * arr[1][1], arr[1][2], arr[1][3]
     * arr[2][0], arr[2][1], arr[2][2]
     */
    private void twoDimensionalArrGenerate() {
        int[][] twoDimArr = new int[3][]; //! Обрати внимание что так можно
        twoDimArr[0] = new int[68];
        twoDimArr[1] = new int[4];
        twoDimArr[2] = new int[19];
        twoDimArr[1][2] = 4; //! так можно
        //! twoDimArr[0] = {1,2,3,4,5}; а так нельзя
        for (int i = 0; i < twoDimArr.length; i++) {
            for (int j = 0; j < twoDimArr[i].length; j++) {
                System.out.print(twoDimArr[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * This method emulates a throwing of bone in the amount of 1000 times
     */
    private void bonesDropEmulation() {
        int[] side = new int[7];
        for (int i = 1; i < 1000; i++) {
            ++side[random.nextInt(6) + 1]; //?
        }
        for (int i = 1; i < side.length; i++) {
            System.out.println("The bone has throws " + side[i] + " times");
        }
    }

    /**
     * Iterates over and displays the entire input two-dimensional array
     */
    private <T extends Comparable> void forEachDoubleArray(T[][] array) {
        for (T[] ar : array) {
            System.out.println(Arrays.toString(ar));
        }
    }

    /**
     * This method finds the minimum int value in the input double array;
     * @return
     */
    private <T extends Comparable, Iterable> T getMinArrayValue(T[][] dualArray) {
        T min = dualArray[0][0];
        for (T[] ar : dualArray) {
            for (int i = 0; i < ar.length; i++) {
                if (ar[i].compareTo(min) < 0) {
                    min = ar[i];
                }
            }
        }
        return min;
    }
}

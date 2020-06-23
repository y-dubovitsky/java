package collections.array;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class shows how to work with simple array.
 */
class ArrayLauncher {

    private static final InputStream INPUT_STREAM = System.in;
    private static final int ARRAY_SIZE = 8;

    public static void main(String[] args) {
        new ArrayLauncher().getIntArray(ARRAY_SIZE, INPUT_STREAM);
    }

    private void getIntArray(int size, InputStream inputStream) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = readIntValue(inputStream);
        }

        printArray(array);
    }

    private int readIntValue(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        System.out.println("Please enter int value");
        return scanner.nextInt();
    }

    private void printArray(int[] array) {
        Arrays.stream(array)
                .forEach(System.err::print);
    }

}

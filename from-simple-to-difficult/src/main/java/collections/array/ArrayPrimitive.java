package collections.array;

import java.util.Scanner;

/**
 * This class shows how we can create an array of a primitive type;
 */
class ArrayPrimitive {

    public static void main(String[] args) {
        ArrayPrimitive pr = new ArrayPrimitive();
        int[] result = pr.createArray();
        for (int i = 0; i < result.length; i++) {
            System.out.println("i" + i + " = " + result[i]);
        }
    }

    /**
     * This method creates an array with user size and fills it with user values;
     * @return - users array.
     */
    private int[] createArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input array size :");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Please enter elements " + size);
        for (int i = size - 1; i > -1; i--) {
            System.out.println("You are input : " + (array[size - i - 1] = scanner.nextInt()));
        }
        return array;
    }
}

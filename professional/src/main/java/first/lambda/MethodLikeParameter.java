package first.lambda;

/**
 * This class implements method from functional Interface
 */
class OuterClass {

    static boolean function(int value) {
        return value % 2 == 0;
    }
}

public class MethodLikeParameter {

    private void someMethod(int[] ar, Interface in) {
        int count = 0;
        for (int i : ar) {
            if (in.function(i)) count++;
        }
        System.out.println("Count " + count);
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10,13,235,57,57,-235,64,-324,6};

        MethodLikeParameter m = new MethodLikeParameter();

        // we used static method like parameter
        m.someMethod(nums, OuterClass::function);
    }
}

interface Interface {
    boolean function(int value);
}

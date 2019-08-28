package first.lambda;

public class LikeParameter {

    // lambda-expression
    Expression<Integer> expression = (Integer x) -> {
        if (x % 2 == 0) {
            return true;
        }
        return false;
    };

    /**
     * This method implemented logic of function interface;
     * @param - array of int
     * @param e - lambda expression
     * @return count of even numbers
     */
    public int summarize(int[] values, Expression<Integer> e) {
        int count = 0;
        for (int i : values)
            if (e.expression(i)) count++;
        return count;
    }

    /**
     * Testing method
     * @param args
     */
    public static void main(String[] args) {
        LikeParameter l = new LikeParameter();
        System.out.println("The amount of even numbers is = " +
                l.summarize(new int[]{1,2,3,4,5,6,7,8,9}, l.expression));
    }
}

interface Expression<T> {
    boolean expression(T t);
}
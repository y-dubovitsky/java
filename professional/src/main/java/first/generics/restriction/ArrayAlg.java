package first.generics.restriction;

public class ArrayAlg {

    /**
     * Return min value;
     * @param a - array
     * @param <T> - must implement comparable;
     * @return
     */
    public static <T extends Comparable> T min(T[] a) {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(ArrayAlg.min(new String[]{"Hello", "My name is", "First"}));
    }
}

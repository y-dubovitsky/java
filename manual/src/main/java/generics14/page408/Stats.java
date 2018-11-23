package main.java.generics14.page408;

public class Stats<T extends Number> {
    T[] nums;
    String str;

    Stats(T[] o) {
        nums = o;
    }

    Stats(String b) {
        str = b;
    }

    double average() {
        double sum = 0.0;
        int i = 0;
        while (i < nums.length) {
            sum += nums[i].doubleValue();
            i++;
        }
        return sum/nums.length;
    }

//    double average() {
//        double sum = 0.0;
//        try {
//        for (int i = 0; i < nums.length; i++) {
//                sum += (Integer) nums[i];
//            }
//        } catch (ClassCastException e) {
//            System.out.println(e.getMessage());
//        }
//        return sum/nums.length;
//    }

    boolean sameAvg(Stats<?> ob) {
        return average() == ob.average();
        // Simple
        //return average() == ob.average() ? true : false;
    }
}

class WildcardDemo {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4,5,6,7,};
        Stats<Integer> iStats = new Stats<Integer>(nums);
        Double[] dnums = {0.1, 0.3, 4.0, 12.0};
        Stats<Double> dStats = new Stats<Double>(dnums);
        System.out.println(iStats.sameAvg(dStats));
        String[] snums = {"a", "b", "c"};
//        Stats<String> sStats = new Stats<String>(snums);
//        System.out.println(iStats.sameAvg(sStats));
    }
}

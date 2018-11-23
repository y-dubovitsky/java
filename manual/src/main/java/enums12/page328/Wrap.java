package main.java.enums12.page328;

public class Wrap {
    static double x;
    public static void main(String args[]) {
        Number number = new Integer(100);
        System.out.println("Output number: " + number);
        System.out.println("Output Integer: " + (Integer) number);
        float fl1 = number.floatValue();
        System.out.println("Output float : " + fl1);
        float fl2 = 123;
        System.out.println("Output float : " + fl2);

        // Use method

        x = Wrap.outBoxing(1234);
        System.out.println("Автоупаковка + Автораспаковка " + x);
    }

    private static double outBoxing(Integer x) {
        return x;
    }
}

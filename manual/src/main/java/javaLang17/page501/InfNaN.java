package main.java.javaLang17.page501;

public class InfNaN {
    public static void main(String[] args) {
        Double d1 = new Double(1/0.);
        Double d2 = new Double(0/0.);
        System.out.println("d1 = " + d1);
        System.out.println("d2 = " + d2);
        System.out.println("d2 не число? " + d2.isNaN());
        System.out.println("d1 не число?? " + d1.isNaN());
        System.out.println("d2 бесконечноть? " + d2.isInfinite());
        System.out.println("d1 бесконечноть? " + d1.isInfinite());
    }
}

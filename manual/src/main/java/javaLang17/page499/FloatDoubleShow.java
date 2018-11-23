package main.java.javaLang17.page499;

public class FloatDoubleShow {
    public static void main(String[] args) {
        Double dbl = new Double(1);
        Double dbl2 = new Double(123.5);
        Float flt = new Float(dbl);
        //
        System.out.println("Сколько байт отведено под double = " + dbl.BYTES);
        System.out.println("Сколько байт отведено под float = " + flt.BYTES);
        System.out.println("Максимальное полож. знач. double = " + dbl.MAX_VALUE);
        System.out.println("Максимальное полож. знач. float = " + flt.MAX_VALUE);
        System.out.println("Min положительное НОРМАЛЬНОЕ ЗНАЧЕНИЕ double = " + dbl.MIN_NORMAL);
        System.out.println("Положительная бесконечность double = " + dbl.POSITIVE_INFINITY);
        System.out.println("Отрицательная бесконечность double = " + dbl.NEGATIVE_INFINITY);
        System.out.println("Размер значения заключенного в оболочку в БИТАХ double = " + dbl.SIZE);
        System.out.println("Размер значения заключенного в оболочку в БИТАХ float = " + flt.SIZE);
        // Сравниваем значения:
        System.out.println("Равно ли значение dbl значению flt? " + dbl.compareTo(flt.doubleValue()));
        System.out.println("Ссылаются ли dbl1 и dbl2 на один и тот же объект? " + dbl.equals(dbl2));
        System.out.println(Double.doubleToLongBits(dbl.doubleValue()));
    }
}

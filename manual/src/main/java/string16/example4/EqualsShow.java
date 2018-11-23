package main.java.string16.example4;

public class EqualsShow {
    public static void main(String[] args) {
        // Ну да sb1 и sb2 ссылаются на один и то же объект в памяти!
        StringBuffer sb1 = new StringBuffer("Я первый объект!");
        StringBuffer sb2 = sb1;
        System.out.println("Емкость sb1 = " + sb1.capacity());
        System.out.println("sb1 это один и тот же объект что sb2? " + sb1.equals(sb2));
        // меняем sb1
        sb2.append(" Добавка");
        System.out.println("Емкость sb1 после добавки = " + sb1.capacity());
        System.out.println("sb1 = " + sb1);
        System.out.println("sb2 = " + sb2);
        System.out.println("sb1 это один и тот же объект что sb2? " + sb1.equals(sb2));
    }
}

package main.java.enums12.page321;

enum Apples {
    Зимнее(10), Летнее, Осеннее, Весеннее;

    private int number;

    Apples(int number) {
        this.number = number;
    }

    Apples() {
        this.number = 0;
    }

    public static void testMethod() {
        System.out.println("Вызвали статический метод поиграться");
    }

    public int getNumber() {
        return this.number;
    }

    /*
    Получаем значение позиции константы в списке перечислений
     */
    protected int getPosition() {
       return ordinal();
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        // Так лучше не делать.
        Apples apples, apples1;
        apples = Apples.Весеннее;
        apples1 = Apples.Зимнее;
        System.out.println(apples.getNumber());
        System.out.println(apples.getPosition());
        // Или так получаем позицию:
        System.out.println(apples.ordinal());
        // Сравниваем два перечисления по позиции
        System.out.println(apples1.compareTo(apples));
    }
}



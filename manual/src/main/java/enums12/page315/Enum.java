package main.java.enums12.page315;

public class Enum {
    public static void main(String[] args) {
        Apple ap;
        ap = Apple.Антоновка;
        System.out.println("Значение ap: " + ap);
        System.out.println(Apple.Антоновка);

        ap = Apple.Дикушка;
        if (ap == Apple.Антоновка) {
            System.out.println("Переменнная ap содержит: Антоновку");
        } else {
            System.out.println(ap);
        }
        Apple apples[] = Apple.values();
        int i = 0;
        for (Apple a : apples) {
            System.out.println(a + " " + i);
            i++;
        }
        Apple bigApple = Apple.valueOf("Яблоко");
        System.out.println(bigApple + " - это большое яблоко");
        bigApple.somothing();
        Apple qwer = Apple.valueOf("Зимнее");
        System.out.println(qwer.value);
    }
}

enum Apple {
    Антоновка, Зимнее(2), Яблоко(3), Дикушка(4);

    public int value;

    Apple(int i) {
        value = i;
    }

    Apple() {
        value = 1904;
    }

    public void somothing() {
        System.out.println(this + " Дратути!");
    }
}

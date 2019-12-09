package java_lessons.enums;

/**
 * Use Enum instead constant!
 */
public class EnumBestPractice {
    // bad practice
    public static final int FRUITE_ORANGE = 1;
    public static final int FRUITE_APPLE = 1;
    public static final int FRUITE_BANANA = 1;

    // good practice
    enum Fruit {
        ORANGE(1),
        APPLE(2),
        BANANA(3);

        int i;

        Fruit(int i) {
            this.i = i;
        }
    }

    public static void main(String[] args) {
    // something code!
    }

}

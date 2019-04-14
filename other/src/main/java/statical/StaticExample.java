package statical;

/**
 * Parents class;
 */
public class StaticExample {

    static int staticVar;
    int objectVar;

    // Static block
    static{
        staticVar = 10;
        System.out.println("Hello");
    }

    public StaticExample() {
        System.out.println(objectVar);
        System.out.println("This is constructor");
    }

    public static void main(String[] args) {
        StaticExample s = new StaticExample();
    }
}

/**
 * Child(descendant) class
 */
class Child extends StaticExample {

    public Child() {
        super(); // This method call by default
        System.out.println("Hello from " + this.getClass().getName());
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}

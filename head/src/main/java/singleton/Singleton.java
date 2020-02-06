package singleton;

/**
 * Singleton pattern
 */
//TODO Нужно добавить код для многопоточности!
public class Singleton {

    /**
     * Object Singleton
     */
    static Singleton singleton;

    /**
     * Private constructor
     */
    private Singleton() {

    }

    /**
     * This method create only one instance of class Singleton;
     */
    public static Singleton createSingleton() {
        if (singleton == null) {
            return singleton = new Singleton();
        } else {
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.createSingleton();
        Singleton singleton1 = Singleton.createSingleton();
        System.out.println(singleton.equals(singleton1) ? "yeas, equals" : "no!");
    }
}

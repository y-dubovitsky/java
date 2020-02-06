package reflection.dynamic;

/**
 * This class we will be load in ModuleEngine.
 */
public class Module implements Modulation{
    public void sout() {
        System.out.println("Hello from " + this.getClass().getCanonicalName());
    }

    public static void main(String[] args) {
        Module module = new Module();
        module.sout();
    }
}

package loader;

/**
 * ClassLoader
 */
public class GetClassLoader {
    public static void main(String[] args) {

        // Get current class Loader
        ClassLoader classLoader = String.class.getClassLoader();

        // not work
        //System.out.println(classLoader.getName());
    }
}

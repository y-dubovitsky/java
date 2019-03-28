package regex30.reflection;

import java.util.Iterator;

/**
 * This class show how to use reflection api.
 */
public class ReflectionCl {

    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("regex30.reflection.MyClass");
            for (int i = 0; i < c.getMethods().length; i++) {

                // !!! Show only public methods
                System.out.println("Method " + i + " " + c.getMethods()[i]);
            }

            // Constructors
            for (int i = 0; i < c.getConstructors().length; i++) {
                System.out.println("Constructors " + i + " " + c.getConstructors()[i]);
            }
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
}

// My Simple class
class MyClass {

    // Fields
    String name;

    // Constructors
    public MyClass() {}

    public MyClass(String str) {
        this.name = str;
    }

    // Methods
    public void method1(){};
    public Iterator<?> method2(){return new Iterator<Object>() {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    };};
    Object method3(){return new Object();};
}

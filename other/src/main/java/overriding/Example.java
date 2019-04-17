package overriding;

/**
 * In this example I am trying to override the class method when creating the object.
 */
public class Example {

    //TODO Did not work out Override method of object!!!
    public void method(Overrided overrided) {
        Overrided o = overrided;

    }

    public static void main(String[] args) {
        // create new object and override method
        Overrided overrided = new Overrided() {
            @Override
            void toOverride() {
                System.out.println("After");
            }
        };
        overrided.toOverride();
    }
}

class Overrided {
    void toOverride() {
        System.out.println("Before");
    }
}

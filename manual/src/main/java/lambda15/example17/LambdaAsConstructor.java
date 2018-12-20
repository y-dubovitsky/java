package lambda15.example17;

interface Interface<T> {
    abstract T construct();
}

class MyClass {
    // Constructor
    MyClass() {
        System.out.println("Hello from MyClass");
    }
    // Method
    void returnValue() {
        System.out.println("From Method");
    }
}

/**
 * Лямбда выражение как конструктор.
 */
public class LambdaAsConstructor {
    public static void main(String[] args) {
        Interface<MyClass> i = MyClass::new; // lambda
        MyClass myClass = i.construct();
        myClass.returnValue();
    }
}


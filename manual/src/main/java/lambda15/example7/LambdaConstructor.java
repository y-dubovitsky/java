package main.java.lambda15.example7;

interface MyInt<T> {
    T myMeth(int i);
}

class MyClass<T> {
    int name;

    MyClass(int name) {
        this.name = name;
    }

    int getName() {
        return this.name;
    }
}

public class LambdaConstructor {
    public static void main(String[] args) {
        MyInt myInt = MyClass<String>::new;
        MyClass myClass = (MyClass)myInt.myMeth(100);
        System.out.println(myClass.getName());
    }
}

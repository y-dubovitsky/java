package main.java.lambda15.example3;

class MyType {
    String name;

    void setName(String name) {
        this.name = name;
    }
}

interface MyInterface {
    MyType intMeth(String a);
}

public class MyLambda3 {
    public static void main(String[] args) {
        MyInterface myInterface = (str) -> {
            MyType myType = new MyType();
            myType.setName(str);
            return myType;
        };
        System.out.println(myInterface.intMeth("Новое Имя!"));
    }
}

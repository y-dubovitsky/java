package main.java.lambda15.example1;

// Создаем функциональный интерфейс
interface MyFunInterface {
    MyClass myFunction(String s);
}

// Создаем свой тип
class MyClass {
    String name = getClass().getName();
    static int value = 0;
    String set;

    MyClass() {
        value++;
    }

    MyClass(String name) {
        super();
        this.name += name + " Дратути ";
    }

    @Override
    public String toString() {
        return this.name + " Overrided!";
    }

    public int getValue() {
        return value;
    }

    public MyClass setSet(String set) {
        this.set = set;
        return this;
    }
}

public class MyLambda {
    public static void main(String[] args) {
        MyClass myClass0 = new MyClass();
        System.out.println("Значение статической переменной равно = " + MyClass.value);
        MyClass myClass = new MyClass();
        System.out.println("Значение статической переменной равно = " + MyClass.value);
        // Реализуем метод функционального интерфейса при помощи лямбда функции:
        MyFunInterface myFunInterface = (n) -> myClass.setSet(n);
        System.out.println(myFunInterface.myFunction("Hello").set);
    }
}

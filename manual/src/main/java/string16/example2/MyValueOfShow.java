package main.java.string16.example2;

class MyClass<T> {
    String name;
    T value;

    public MyClass() {
        name = new MyClass().getClass().getName();
    }

    public MyClass(T val) {
        super();
        value = val;
    }

    @Override
    public String toString() {
        return "Мы переопределили метод toString, имя класса - " + this.name;
    }
}

public class MyValueOfShow {

    private static String valueOf(MyClass[] myClasses) {
        String result = new String();
        for (int i = 0; i < myClasses.length; i++) {
            result += myClasses[i].value + System.lineSeparator();
        }
        return result;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass(123);
        System.out.println(myClass);
        String str = String.valueOf(myClass);
        System.out.println(str);
        // Вызовем valueOf для массива:
        int[] intArray = {123,54,634,63,523,562,54};
        System.out.println(String.valueOf(intArray));
        //
        MyClass[] myClasses = {new MyClass(4), new MyClass(34), new MyClass("Дратути!")};
        System.out.println(valueOf(myClasses).toUpperCase());

    }
}

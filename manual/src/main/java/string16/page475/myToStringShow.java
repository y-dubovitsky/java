package main.java.string16.page475;

class MyException extends Exception {
    MyException(String attention) {
        super(attention);
    }
}

class MyClass {
    int value;
    String name;

    MyClass() {
        value = 1234;
        name = getClass().getName();
    }

    MyClass(int a) {
        super();
        value = a;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}

public class myToStringShow {
    public static void main(String[] args) {
        MyClass myClass = new MyClass(0043221);
        String str = new String();
        System.out.println("Пустой объект - " + str);
        str = new String(myClass.toString());
        System.out.println("В старой ссылочной переменной новый объект - " + str);
        String[] indexString = {"HELLO INDEX STRING"};
        System.out.println(indexString[0]);
        String testString = "0123456789";
        System.out.println(testString.charAt(0));
        // Создаем массив chars из строки
        char[] chars = new char[testString.length()];
        for (int i = 0; i < testString.length(); i++) {
            chars[i] = testString.charAt(i);
        }
        int i = 0;
        try {
            if (chars.length < 100) {
                throw new MyException("Длинна массива равно 0");
            }
            do {
                chars[i] += 10 * Math.random();
                System.out.println(chars[i]);
                i++;
            } while (i < chars.length);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }
}

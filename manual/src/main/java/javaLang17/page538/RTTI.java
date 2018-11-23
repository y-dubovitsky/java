package main.java.javaLang17.page538;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class X {
    int a;
    float b;
}

class Y extends X {
    double c;

    Y() {

    }

    Y(int a) {

    }

    public void enter() {
        System.out.println("ENTER! METHOD OF CLASS Y");
    }
}

public class RTTI {
    public static void main(String[] args) throws ClassNotFoundException {
        X x = new X();
        Y y = new Y();
        Class<?> clObj;
        clObj = x.getClass();
        System.out.println("x - object type: " + clObj.getName());
        clObj = y.getClass();
        System.out.println("y - object type: " + clObj.getName());
        clObj = clObj.getSuperclass();
        System.out.println("super class object y: " + clObj.getName());
        /* Attention! */
        System.out.println(Class.forName("main.java.javaLang17.page538.Y").getSuperclass());
        // Fields
        Field[] fields = new Field[5];
        fields = clObj.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Object type " + clObj.getName() + " have fields: " + fields[i]);
        }
        // Methods
        Method[] methods = new Method[5];
        clObj = y.getClass();
        methods = clObj.getMethods();
        Constructor[] constructor = clObj.getDeclaredConstructors();
        for (int i = 0; i < fields.length; i++) {
            System.out.println("Object type " + clObj.getName() + " have methods: " + methods[i]);
            /* Выскочет ошибка, лень было писать нормально
            * Но тут Будет конструктор по умолчанию =)
            */
            System.out.println("And Constructors: " + constructor[i]);
        }
        // ClassLoader
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}

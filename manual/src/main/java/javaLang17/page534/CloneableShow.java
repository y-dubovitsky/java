package main.java.javaLang17.page534;

class MyClass {
    int var;

    MyClass(int a) {
        var = a;
    }
}

class TestClone implements Cloneable {
    int a;
    double b;
    MyClass myClass;

    TestClone cloneTest() {
        try {
            return (TestClone)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return this;
        }
    }
}

public class CloneableShow {
    public static void main(String[] args) {
        TestClone x1 = new TestClone();
        MyClass myClass = new MyClass(1904);
        x1.myClass = myClass;
        TestClone x2;
        x1.a = 123;
        x1.b = 123.41;
        x2 = x1.cloneTest();
        System.out.println(x1.a + " " + x2.a + " x1.myClass.var= " + x1.myClass.var + " x2 " + x2.myClass.var);
        x2.a = 45;
        // Клон внес изменения в ОБЩИЙ объект, и тем самым поменял x1.
        x2.myClass.var = 1234567890;
        System.out.println(x1.a + " " + x2.a + " x1.myClass.var= " + x1.myClass.var + " x2 " + x2.myClass.var);
    }
}

package lambda15.page461;

interface MyInterface {
    MyDoubleClass func(int i);
}

class MyClass {
    private int val;

    MyClass(int val) {
        this.val = val;
    }

    MyClass() {
        val = 0;
    }

    int getVal() {
        return val;
    }
}

class MyDoubleClass extends MyClass {
    MyDoubleClass(int i) {
        super(i);
    }
};

public class ConstructorRefDemo {
    public static void main(String[] args) {
        MyInterface myClassConst = MyDoubleClass::new;
        MyDoubleClass mc = myClassConst.func(100);
        System.out.println(mc.getVal());
    }
}

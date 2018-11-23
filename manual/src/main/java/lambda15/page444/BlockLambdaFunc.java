package main.java.lambda15.page444;

class MyLambdaTestClass {
    String name;

    void MyLambdaTestClass() {
        name +=  getClass().getName();
        System.out.println(this.name);
    }
}

interface MyFuncInterface {
    MyLambdaTestClass test(MyLambdaTestClass myLambdaTestClass);
}

class MyBlockLambdaFunc {
    public static void main(String[] args) {
        MyFuncInterface myFuncInterface = (something) -> {
            MyLambdaTestClass my = new MyLambdaTestClass();
            my.name += " Лямбда выражение вперед! ";
            return my;
        };
        MyLambdaTestClass myLambdaTestClass = new MyLambdaTestClass();
        myFuncInterface.test(myLambdaTestClass).MyLambdaTestClass();
    }
}

interface NumericFunction<T extends Integer> {
    T func (T t);
}

public class BlockLambdaFunc {
    public static void main(String[] args) {
        NumericFunction numericFunction = (t) -> {
            Integer result = 1;
            for (Integer i = 1; i <= t; i++) result = i * result;
            return result;
        };
        System.out.println(numericFunction.func(5));
        System.out.println(numericFunction.func(12));
    }
}



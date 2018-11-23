package main.java.string16.exmaple6;

class MyClassOne {
    int myFun(int a, int b) {
        return a + b;
    }
}

class MyClassTwo extends MyClassOne {
    int myFun(int a, int b) {
        return super.myFun(14, 54) * b;
    }
}

public class SuperShow {
    public static void main(String[] args) {
        MyClassTwo myClassTwo = new MyClassTwo();
        System.out.println(myClassTwo.myFun(4,4));
    }
}

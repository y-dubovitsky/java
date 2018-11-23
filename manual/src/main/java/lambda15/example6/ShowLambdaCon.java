package main.java.lambda15.example6;

interface MyInterface {
    MyLambdaConstructor MyIntMethod(String a);
}

class MyLambdaConstructor {
    private String variable;

    MyLambdaConstructor(String i) {
        variable = i;
    }

    public String getVariable() {
        return variable;
    }
}

public class ShowLambdaCon {
    public static void main(String[] args) {
        MyInterface mi = MyLambdaConstructor::new;
        MyLambdaConstructor mlc = mi.MyIntMethod("Дратути!");
        System.out.println(mlc.getVariable());
    }
}


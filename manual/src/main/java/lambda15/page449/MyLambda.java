package main.java.lambda15.page449;

interface FuncInt {
    String func(String a);
}

public class MyLambda {

    public String strOut(FuncInt funcInt, String str) {
        return funcInt.func(str);
    }

    public static void main(String[] args) {
        MyLambda myLambda = new MyLambda();
        String out = myLambda.strOut((someString) -> someString.toUpperCase(), " Дратути! ");
        System.out.println(out);
        //
        out = myLambda.strOut((elseString) -> {
            for (int a = 0; a < 5; a++) {
                elseString += a;
            }
            return elseString;
        }, "Java Rulllez");
        System.out.println(out);
        //
        FuncInt funcInt = (allStringForever) -> allStringForever + " STRING STRING STRING !!!";
        System.out.println(myLambda.strOut(funcInt, "bla bla bla"));
    }
}

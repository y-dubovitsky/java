package main.java.lambda15.example5;

interface MyFuncInt<T> {
    boolean myFunc(T[] array, T t);
}

public class MyLambdaShow {
    public static void main(String[] args) {
        MyFuncInt myFuncInt = (n,v) -> {
            boolean answer = false;
            for (int i = 0; i < n.length; i++) {
                if (n[i].equals(v)) {
                    System.out.println("n" + i + " содержит " + v);
                    answer = true;
                }
            }
            return answer;
        };
        //String[] strAr = {"Matthey", "Jam", "Sam"};
        System.out.println(myFuncInt.myFunc(new String[]{"Matthey", "Jam", "Sam"},"Jam"));
    }
}

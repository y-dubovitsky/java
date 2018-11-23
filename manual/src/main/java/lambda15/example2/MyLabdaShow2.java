package main.java.lambda15.example2;

interface MyInterface {
    String interfaceMeth(String a);
}

class MyException extends Exception {
    MyException() {
        super("Do you love my exception?");
    }
}

public class MyLabdaShow2 {
    public static void main(String[] args) throws MyException {
        MyInterface mi = (n) -> {
            String result = "";
            for (int i = n.length() - 1; i >= 0; i--) {
                result += n.charAt(i);
            }
            return result;
        };
        System.out.println(mi.interfaceMeth("Дратути!"));
        mi = (n) -> "Hello Dear! " + n;
        String[] names = {
                "Петя",
                "Эля",
                "Борис"
        };
        try {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals("Зоя")) {
                    throw new MyException();
                }
                System.out.println(mi.interfaceMeth(names[i]));
            }
        } catch (MyException e) {
            System.out.println("Мы обработали мое исключение!");
        } finally {
            System.out.println("Выводится в любом случае =)");
        }
    }
}

package main.java.javaLang17.page557;

enum Fruits {
    String1, qwer, sf3gf, StrFr("СТРОКА СТРОКА СТРОКА");

    private String price;

    Fruits() {
        System.out.println("Дратути!");
    }

    Fruits(String str) {
        price = str;
    }

    public void sumEnum() {
        System.out.println(qwer + " " + String1);
    }

    public static void sumEnumStatic() {
        System.out.println(String1 + " static");
    }

    public static void main(String[] args) {
        Fruits fruits;
        fruits = Fruits.qwer;
        fruits = Fruits.StrFr;
        System.out.println(Fruits.StrFr.price);
        //System.out.println(fruits);
        //fruits.sumEnum();
        //Fruits.sumEnumStatic();
    }
}

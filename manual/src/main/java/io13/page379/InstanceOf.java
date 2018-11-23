package main.java.io13.page379;

public class InstanceOf {
    public static class A {
        int a;
        public void bb() {
            System.out.println("Дратутти A!");
        }
    }

    public static class B extends A {
        int b;
        public void bb() {
            System.out.println("Дратутти!");
        }
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        A aa = new B();
        aa.bb();
        B bb = new B();

        if (a instanceof B) {
            System.out.println("А может быть приведен к классу Б");
        } else {
            System.out.println("А НЕ может быть приведен к классу Б");
        }

        if (b instanceof A) {
            System.out.println("Б может быть приведен к классу А");
        } else {
            System.out.println("Б НЕ может быть приведен к классу А");
        }
    }
}

package main.java.io13.page386;

public class AssertDemo {
    private int a;
    AssertDemo(int a) {
        this.a = a;
    }
    public int age() {
        return a--;
    }

    public static void main(String[] args) {
        AssertDemo assertDemo = new AssertDemo(14);
        for (int i = 0; i < 20; i++) {
            boolean a = true;
            assert(a = assertDemo.age() > 0);
            System.out.println(a + " " + i);
            //assert a > 0;
        }
    }
}

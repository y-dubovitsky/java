package multithreads;

public class Fibonacci implements Runnable{

    private int n;
    private int n0 = 0;
    private int n1 = 1;
    private int n2;
    private static int id = 0;

    public Fibonacci(int value) {
        this.n = value;
    }

    @Override
    public void run() {
        while (n2 < n) {
            System.out.print(n0+" "+n1+" ");
            for(int i = 3; i <= 11; i++){
                n2=n0+n1;
                System.out.println(" " + n2+" ");
                n0=n1;
                n1=n2;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Fibonacci(10)).start();
        }
    }
}

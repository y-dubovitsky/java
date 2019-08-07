package multithreads.join;

public class Sleeper extends Thread {

    private int time;

    public Sleeper(int time) {
        this.time = time;
        start();
    }

    public void run() {
        try {
            System.out.println(this.getClass().getCanonicalName() + " starting working");
            sleep(time);
            System.out.println(this.getClass().getCanonicalName() + " ending work!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Joiner extends Thread {

    Thread t;

    public Joiner(Thread t){
        super("Joiner");
        this.t = t;
        start();
    }

    public void run() {
        System.out.println("Starting " + this.getClass().getCanonicalName());
        try {
            t.join();
        } catch (InterruptedException i) {
            i.printStackTrace();
        }
        System.out.println("Ending " + this.getName());
    }
}

class StartingApp {
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper(10000);
        Joiner joiner = new Joiner(sleeper);
    }
}

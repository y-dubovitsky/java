package network.threads.race;

/**
 * Main test class;
 */
public class Operation {
    public static void main(String[] args) {
        Clients clients = new Clients(new BankAccount(300));
        Thread one = new Thread(clients);
        Thread two = new Thread(clients);
        one.setName("First Client");
        two.setName("Second Client");
        one.start();
        two.start();
    }
}

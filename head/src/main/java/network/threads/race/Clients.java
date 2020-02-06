package network.threads.race;

public class Clients implements Runnable{

    private BankAccount bankAccount;

    public Clients(BankAccount b) {
        this.bankAccount = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.getMoney(10);
            if (bankAccount.getBalance() < 0) {
                System.out.println("You limit is exceed!");
            }
        }
    }

    /**
     * Withdraw money from the account
     * @param amount
     */
    private synchronized void getMoney(int amount) {
        System.out.println(Thread.currentThread().getName() + " trying get " + amount + " money");
        if (this.bankAccount.getBalance() > amount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.bankAccount.changeBalance(amount);
            System.out.println("After " + Thread.currentThread().getName() + " balance = " + this.bankAccount.getBalance());
        } else {
            System.out.println("You lack of money");
        }
    }
}

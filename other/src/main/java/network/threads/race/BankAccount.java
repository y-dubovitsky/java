package network.threads.race;

/**
 * This class describes bank account;
 */
public class BankAccount {

    /**
     * Balance
     */
    private int balance;

    public BankAccount(int value) {
        this.balance = value;
    }

    /**
     * Return balance
     * @return
     */
    public int getBalance() {
        return balance;
    }

    public void changeBalance(int value) {
        this.balance -= value;
    }
}

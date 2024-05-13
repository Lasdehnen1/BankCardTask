package org.example;
/**
 *
 */
public abstract class BankCard {
    protected double balance;

    public BankCard(double balance) {
        this.balance = balance;
    }

    public abstract void topUpBalance(double amount);
    public abstract boolean payment(double amount);

    public double getBalance() {
        System.out.println("Общий баланс карты: " + balance);
        return balance;
    }
    public abstract void getAvailableBalance();
}

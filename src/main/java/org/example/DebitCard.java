package org.example;

public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public void topUpBalance(double amount) {
        balance += amount;
    }

    @Override
    public boolean payment(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public void getAvailableBalance() {
        System.out.println("Баланс дебетовой карты: " + balance);
    }
}

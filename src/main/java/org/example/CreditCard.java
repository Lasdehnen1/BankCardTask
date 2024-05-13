package org.example;

public class CreditCard extends BankCard {
    private final double creditLimit;
    private double creditBalance;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        this.creditLimit = creditLimit;
        this.creditBalance = creditLimit;
    }
    @Override
    public void topUpBalance(double amount) {
        if (creditBalance < creditLimit) {
            double remainingCredit = creditLimit - creditBalance;
            if (amount <= remainingCredit) {
                creditBalance += amount;
            } else {
                balance += amount - remainingCredit;
                creditBalance = creditLimit;
            }
        } else {
            balance += amount;
        }
    }

    @Override
    public boolean payment(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else if (balance + creditBalance >= amount) {
            double amountToPay = amount - balance;
            balance = 0;
            creditBalance -= amountToPay;
            return true;
        }
        return false;
    }

    @Override
    public double getBalance() {
        double overallBalance = balance + creditBalance;
        System.out.println("Общий баланс карты: " + overallBalance);
        return overallBalance;
    }

    @Override
    public void getAvailableBalance() {
        System.out.println("Баланс собственных средств: " + balance);
        System.out.println("Баланс кредитного лимита: " + creditBalance);
    }
}

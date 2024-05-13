package org.example;

public class CreditCardBonus extends CreditCard {
    private final double minCashback; // минимальный процент
    private final double maxCashback; // максимальный процент
    private final double maxCashbackSum; // сумма при которой начисляется повышенный кешбэк

    private double cashBackSum; // общая сумма кешбэка

    public CreditCardBonus(double balance, double creditLimit, double minCashback, double maxCashback, double maxCashbackSum) {
        super(balance, creditLimit);
        this.minCashback = minCashback;
        this.maxCashback = maxCashback;
        this.maxCashbackSum = maxCashbackSum;
    }

    @Override
    public boolean payment(double amount) {
        double cashback;
        if (amount > maxCashbackSum) {
            cashback = amount * maxCashback;
            cashBackSum += cashback;
            System.out.println("Сумма кешбэка: " + cashback);
        } else {
            cashback = amount * minCashback;
            cashBackSum += cashback;
            System.out.println("Сумма кешбэка: " + cashback);
        }
        return super.payment(amount);
    }
    @Override
    public void getAvailableBalance() {
        super.getAvailableBalance();
        System.out.println("Общий кешбэк: " + cashBackSum);
    }
}

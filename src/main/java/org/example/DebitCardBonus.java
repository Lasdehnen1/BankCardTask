package org.example;

public class DebitCardBonus extends DebitCard {
    private final double minCashback; // минимальный процент
    private final double maxCashback; // максимальный процент
    private final double maxCashbackSum; // сумма при которой начисляется повышенный кешбэк
    private final double bonusRate; // процент при пополнении
    private double cashBackSum; // общая сумма кешбэка

    public DebitCardBonus(double balance, double minCashback, double maxCashback, double maxCashbackSum, double bonusRate) {
        super(balance);
        this.minCashback = minCashback;
        this.maxCashback = maxCashback;
        this.maxCashbackSum = maxCashbackSum;
        this.bonusRate = bonusRate;
    }

    @Override
    public void topUpBalance(double amount) {
        super.topUpBalance(amount);
        double bonusPoints = amount * bonusRate;
        balance += bonusPoints;
        System.out.println("Начислен процент за пополнение: " + bonusPoints);
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

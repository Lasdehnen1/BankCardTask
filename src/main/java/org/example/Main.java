package org.example;

public class Main {
    public static void main(String[] args) {

        DebitCard debitCard = new DebitCard(5000);
        debitCard.topUpBalance(2000); // пополнение баланса
        debitCard.getAvailableBalance(); // информация о балансе
        boolean paymentResult = debitCard.payment(3000); // покупка
        System.out.println("Оплата прошла успешно: " + paymentResult);
        debitCard.getAvailableBalance();

        System.out.println();

        CreditCard creditCard = new CreditCard(0, 10000);
        creditCard.topUpBalance(5000); // пополнение баланса
        creditCard.getAvailableBalance(); // информация о балансе
        paymentResult = creditCard.payment(14000); // покупка
        System.out.println("Оплата прошла успешно: " + paymentResult);
        creditCard.topUpBalance(3000);
        creditCard.getAvailableBalance();

        System.out.println();

        DebitCardBonus debitCardBonus = new DebitCardBonus(0, 0.01, 0.05, 5000, 0.005);
        debitCardBonus.topUpBalance(7000); // пополнение баланса
        debitCardBonus.getAvailableBalance(); // информация о балансе
        paymentResult = debitCardBonus.payment(5500); // покупка
        System.out.println("Оплата прошла успешно: " + paymentResult);
        debitCardBonus.payment(1000);
        debitCardBonus.getAvailableBalance();

        System.out.println();

        CreditCardBonus creditCardBonus = new CreditCardBonus(0, 10000, 0.01, 0.05, 5000);
        creditCardBonus.topUpBalance(5000); // пополнение баланса
        creditCardBonus.getAvailableBalance(); // информация о балансе
        paymentResult = creditCardBonus.payment(14000); // покупка
        System.out.println("Оплата прошла успешно: " + paymentResult);
        creditCardBonus.topUpBalance(3000);
        creditCardBonus.getAvailableBalance();
        creditCardBonus.topUpBalance(10000);
        creditCardBonus.payment(3500);
        creditCardBonus.getAvailableBalance();
        creditCardBonus.getBalance();
    }
}
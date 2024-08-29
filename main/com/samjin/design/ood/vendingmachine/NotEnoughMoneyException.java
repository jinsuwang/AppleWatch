package com.samjin.design.ood.vendingmachine;


public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException() {
        super("Not enough money inserted to complete the transaction.");
    }
}

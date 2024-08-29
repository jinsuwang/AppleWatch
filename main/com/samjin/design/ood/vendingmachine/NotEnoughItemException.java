package com.samjin.design.ood.vendingmachine;

public class NotEnoughItemException extends Exception {
    public NotEnoughItemException() {
        super("The selected item is not available.");
    }
}

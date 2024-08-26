package com.samjin.design.ood.ordersystem;

public class Customer extends User {
    private ShoppingCart cart;

    public Customer(String userId, String name, String email) {
        super(userId, name, email);
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart() {
        return cart;
    }
}
package com.samjin.design.ood.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;
    private boolean isPaid;

    public Order() {
        items = new ArrayList<>();
        isPaid = false;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void pay() {
        isPaid = true;
    }

    public boolean isPaid() {
        return isPaid;
    }
}

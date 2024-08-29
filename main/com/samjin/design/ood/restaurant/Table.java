package com.samjin.design.ood.restaurant;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private int tableNumber;
    private List<Order> orders;

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        orders = new ArrayList<>();
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double calculateTotalForTable() {
        double total = 0;
        for (Order order : orders) {
            total += order.calculateTotal();
        }
        return total;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

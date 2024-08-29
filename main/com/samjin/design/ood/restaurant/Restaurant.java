package com.samjin.design.ood.restaurant;

import java.util.HashMap;
import java.util.Map;

public class Restaurant {

    private Menu menu;
    private Map<Integer, Table> tables;

    public Restaurant() {
        menu = new Menu();
        tables = new HashMap<>();
    }

    public Menu getMenu() {
        return menu;
    }

    public void addTable(int tableNumber) {
        tables.put(tableNumber, new Table(tableNumber));
    }

    public Table getTable(int tableNumber) {
        return tables.get(tableNumber);
    }

    public void placeOrder(int tableNumber, Order order) {
        Table table = tables.get(tableNumber);
        if (table != null) {
            table.addOrder(order);
        } else {
            System.out.println("Table not found!");
        }
    }

    public double calculateTotalRevenue() {
        double total = 0;
        for (Table table : tables.values()) {
            total += table.calculateTotalForTable();
        }
        return total;
    }
}

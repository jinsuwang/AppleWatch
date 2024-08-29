package com.samjin.design.ood.restaurant;

public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        // Adding items to the menu
        restaurant.getMenu().addItem(new MenuItem("Burger", "Delicious beef burger", 8.99));
        restaurant.getMenu().addItem(new MenuItem("Pizza", "Cheese pizza", 12.99));

        // Adding tables
        restaurant.addTable(1);
        restaurant.addTable(2);

        // Placing an order at table 1
        Order order1 = new Order();
        order1.addItem(new OrderItem(restaurant.getMenu().findItemByName("Burger"), 2));
        order1.addItem(new OrderItem(restaurant.getMenu().findItemByName("Pizza"), 1));
        restaurant.placeOrder(1, order1);

        // Placing another order at table 1
        Order order2 = new Order();
        order2.addItem(new OrderItem(restaurant.getMenu().findItemByName("Burger"), 1));
        restaurant.placeOrder(1, order2);

        // Calculate the total for table 1
        System.out.println("Total for table 1: $" + restaurant.getTable(1).calculateTotalForTable());

        // Calculate the total revenue for the restaurant
        System.out.println("Total revenue: $" + restaurant.calculateTotalRevenue());

    }
}

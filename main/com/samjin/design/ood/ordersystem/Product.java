package com.samjin.design.ood.ordersystem;

public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private int inventoryCount;

    public Product(String id, String name, String description, double price, int inventoryCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.inventoryCount = inventoryCount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getInventoryCount() {
        return inventoryCount;
    }

    public void reduceInventory(int quantity) {
        if (quantity <= inventoryCount) {
            inventoryCount -= quantity;
        } else {
            throw new IllegalArgumentException("Insufficient inventory");
        }
    }
}

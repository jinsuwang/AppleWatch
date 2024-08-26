package com.samjin.design.ood.ordersystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> items;
    private double totalAmount;
    private String status;
    private Date orderDate;

    public Order(Customer customer, ShoppingCart cart) {
        this.orderId = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = new HashMap<>(cart.getItems());
        this.totalAmount = cart.calculateTotal();
        this.status = "Pending";
        this.orderDate = new Date();
    }

    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void processOrder() {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceInventory(entry.getValue());
        }
        this.status = "Processing";
    }
}

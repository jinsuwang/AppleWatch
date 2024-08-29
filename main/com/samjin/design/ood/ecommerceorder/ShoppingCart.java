package com.samjin.design.ood.ecommerceorder;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        if (product.getInventoryCount() >= quantity) {
            items.put(product, items.getOrDefault(product, 0) + quantity);
        } else {
            throw new IllegalArgumentException("Insufficient inventory");
        }
    }

    public void removeItem(Product product) {
        items.remove(product);
    }

    public double calculateTotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public void clearCart() {
        items.clear();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
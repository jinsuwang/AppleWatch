package com.samjin.design.ood.ecommerceorder;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private Order order;
    private double amount;
    private String paymentMethod;
    private String status;

    public Payment(Order order, String paymentMethod) {
        this.paymentId = UUID.randomUUID().toString();
        this.order = order;
        this.amount = order.getTotalAmount();
        this.paymentMethod = paymentMethod;
        this.status = "Pending";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Order getOrder() {
        return order;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void processPayment() {
        // Simulate payment processing
        this.status = "Completed";
        order.setStatus("Completed");
    }
}


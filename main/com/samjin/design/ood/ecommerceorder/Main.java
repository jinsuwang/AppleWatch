package com.samjin.design.ood.ecommerceorder;

public class Main {

    public static void main(String[] args) {
        // Create a product
        Product product1 = new Product("P001", "Laptop", "Gaming Laptop", 1200.00, 10);

        // Create a customer
        Customer customer = new Customer("C001", "John Doe", "john@example.com");

        // Customer adds items to cart
        customer.getCart().addItem(product1, 2);

        // Create an order
        Order order = new Order(customer, customer.getCart());
        order.processOrder();

        // Process payment
        Payment payment = new Payment(order, "Credit Card");
        payment.processPayment();

        // Output order and payment status
        System.out.println("Order Status: " + order.getStatus());
        System.out.println("Payment Status: " + payment.getStatus());
    }
}

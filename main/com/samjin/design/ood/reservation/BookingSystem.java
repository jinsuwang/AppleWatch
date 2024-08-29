package com.samjin.design.ood.reservation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class BookingSystem {
    public static void main(String[] args) {
        // Initialize restaurant with tables
        List<Table> tables = Arrays.asList(
                new Table(1, 2),
                new Table(2, 4),
                new Table(3, 4),
                new Table(4, 6)
        );

        Restaurant restaurant = new Restaurant(tables);

        // Customer makes a reservation
        Customer customer1 = new Customer("John Doe", "123-456-7890");
        Reservation reservation1 = restaurant.makeReservation(customer1, 2, LocalDateTime.now().plusDays(1));

        if (reservation1 != null) {
            System.out.println("Reservation successful for " + customer1.getName() + " at table " + reservation1.getTable().getTableId());
        } else {
            System.out.println("No available table for the requested party size.");
        }

        // Customer makes another reservation
        Customer customer2 = new Customer("Jane Doe", "987-654-3210");
        Reservation reservation2 = restaurant.makeReservation(customer2, 4, LocalDateTime.now().plusDays(2));

        if (reservation2 != null) {
            System.out.println("Reservation successful for " + customer2.getName() + " at table " + reservation2.getTable().getTableId());
        } else {
            System.out.println("No available table for the requested party size.");
        }

        // Cancel a reservation
        if (restaurant.cancelReservation(reservation1)) {
            System.out.println("Reservation cancelled successfully.");
        } else {
            System.out.println("Failed to cancel reservation.");
        }

        // View all reservations
        List<Reservation> allReservations = restaurant.getReservations();
        System.out.println("Current reservations:");
        for (Reservation res : allReservations) {
            System.out.println("Customer: " + res.getCustomer().getName() + ", Table: " + res.getTable().getTableId() + ", Time: " + res.getReservationTime());
        }
    }
}

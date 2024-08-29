package com.samjin.design.ood.reservation;

import java.time.LocalDateTime;

public class Reservation {

    private Customer customer;
    private Table table;
    private LocalDateTime reservationTime;

    public Reservation(Customer customer, Table table, LocalDateTime reservationTime) {
        this.customer = customer;
        this.table = table;
        this.reservationTime = reservationTime;
        table.reserve(); // Reserve the table
    }

    public Customer getCustomer() {
        return customer;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void cancelReservation() {
        table.unreserve();
    }
}

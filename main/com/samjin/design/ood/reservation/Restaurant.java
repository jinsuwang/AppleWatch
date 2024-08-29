package com.samjin.design.ood.reservation;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<Table> tables;
    private List<Reservation> reservations;

    public Restaurant(List<Table> tables) {
        this.tables = tables;
        this.reservations = new ArrayList<>();
    }

    public List<Table> getAvailableTables(int partySize) {
        List<Table> availableTables = new ArrayList<>();
        for (Table table : tables) {
            if (!table.isReserved() && table.getCapacity() >= partySize) {
                availableTables.add(table);
            }
        }
        return availableTables;
    }

    public Reservation makeReservation(Customer customer, int partySize, LocalDateTime reservationTime) {
        List<Table> availableTables = getAvailableTables(partySize);
        if (!availableTables.isEmpty()) {
            Table table = availableTables.get(0);
            Reservation reservation = new Reservation(customer, table, reservationTime);
            reservations.add(reservation);
            return reservation;
        }
        return null; // No available table
    }

    public boolean cancelReservation(Reservation reservation) {
        if (reservations.remove(reservation)) {
            reservation.cancelReservation();
            return true;
        }
        return false;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
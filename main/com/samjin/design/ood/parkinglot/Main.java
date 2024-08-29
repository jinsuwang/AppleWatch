package com.samjin.design.ood.parkinglot;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(10, 5, 2);

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("XYZ789");
        Vehicle bus = new Bus("BUS456");

        System.out.println("Parking car: " + lot.parkVehicle(car));
        System.out.println("Parking motorcycle: " + lot.parkVehicle(motorcycle));
        System.out.println("Parking bus: " + lot.parkVehicle(bus));

        lot.removeVehicle(car);
        System.out.println("Car removed. Parking another car: " + lot.parkVehicle(new Car("DEF456")));
    }
}

package com.samjin.design.ood.parkinglot;

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, VehicleSize.LARGE);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return spot.getSize() == VehicleSize.LARGE;
    }
}

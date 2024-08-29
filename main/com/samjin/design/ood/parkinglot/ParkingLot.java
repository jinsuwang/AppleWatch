package com.samjin.design.ood.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private List<ParkingSpot> spots;

    public ParkingLot(int numCompactSpots, int numLargeSpots, int numMotorcycleSpots) {
        spots = new ArrayList<>();
        for (int i = 0; i < numCompactSpots; i++) {
            spots.add(new ParkingSpot(VehicleSize.COMPACT));
        }
        for (int i = 0; i < numLargeSpots; i++) {
            spots.add(new ParkingSpot(VehicleSize.LARGE));
        }
        for (int i = 0; i < numMotorcycleSpots; i++) {
            spots.add(new ParkingSpot(VehicleSize.MOTORCYCLE));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.park(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void removeVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (!spot.isAvailable() && spot.getSize() == vehicle.getSize() && spot.getVehicle().getLicensePlate().equals(vehicle.getLicensePlate())) {
                spot.removeVehicle();
                return;
            }
        }
    }

}

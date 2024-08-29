package com.samjin.design.ood.parkinglot;

public class ParkingSpot {
    private VehicleSize size;
    private Vehicle currentVehicle;

    public ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    public boolean isAvailable() {
        return currentVehicle == null;
    }

    public VehicleSize getSize() {
        return size;
    }

    public boolean park(Vehicle vehicle) {
        if (isAvailable() && vehicle.canFitInSpot(this)) {
            currentVehicle = vehicle;
            return true;
        }
        return false;
    }

    public Vehicle getVehicle(){
        return currentVehicle;
    }

    public void removeVehicle() {
        currentVehicle = null;
    }
}

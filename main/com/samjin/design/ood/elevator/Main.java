package com.samjin.design.ood.elevator;

public class Main {
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController(2); // A building with 2 elevators

        // External requests (from different floors)
        controller.handleExternalRequest(3, ElevatorDirection.UP);
        controller.handleExternalRequest(5, ElevatorDirection.DOWN);

        // Internal requests (from inside an elevator)
        controller.handleInternalRequest(0, 7); // Elevator 0 is asked to go to the 7th floor
        controller.handleInternalRequest(1, 2); // Elevator 1 is asked to go to the 2nd floor
    }
}

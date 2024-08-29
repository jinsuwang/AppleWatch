package com.samjin.design.ood.elevator;

import java.util.List;
import java.util.ArrayList;

public class ElevatorController {

    private List<Elevator> elevators;

    public ElevatorController(int numberOfElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numberOfElevators; i++) {
            elevators.add(new Elevator());
        }
    }

    public void handleExternalRequest(int floor, ElevatorDirection direction) {
        Elevator bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            bestElevator.addRequest(new ElevatorRequest(floor, direction));
        }
    }

    private Elevator findBestElevator(int floor, ElevatorDirection direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.getState() == ElevatorState.IDLE) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        return bestElevator;
    }

    public void handleInternalRequest(int elevatorId, int destinationFloor) {
        if (elevatorId >= 0 && elevatorId < elevators.size()) {
            Elevator elevator = elevators.get(elevatorId);
            ElevatorDirection direction = destinationFloor > elevator.getCurrentFloor() ? ElevatorDirection.UP : ElevatorDirection.DOWN;
            elevator.addRequest(new ElevatorRequest(destinationFloor, direction));
        }
    }
}

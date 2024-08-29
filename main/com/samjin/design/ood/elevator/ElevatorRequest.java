package com.samjin.design.ood.elevator;

public class ElevatorRequest {

    private int requestedFloor;
    private ElevatorDirection direction;

    public ElevatorRequest(int requestedFloor, ElevatorDirection direction) {
        this.requestedFloor = requestedFloor;
        this.direction = direction;
    }

    public int getRequestedFloor() {
        return requestedFloor;
    }

    public ElevatorDirection getDirection() {
        return direction;
    }
}

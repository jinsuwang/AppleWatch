package com.samjin.design.ood.elevator;

import java.util.Queue;
import java.util.PriorityQueue;

public class Elevator {

    private int currentFloor;
    private ElevatorState state;
    private Queue<ElevatorRequest> upQueue;
    private Queue<ElevatorRequest> downQueue;

    public Elevator() {
        this.currentFloor = 0; // Assume ground floor as 0
        this.state = ElevatorState.IDLE;
        this.upQueue = new PriorityQueue<>((a, b) -> a.getRequestedFloor() - b.getRequestedFloor());
        this.downQueue = new PriorityQueue<>((a, b) -> b.getRequestedFloor() - a.getRequestedFloor());
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void addRequest(ElevatorRequest request) {
        if (request.getDirection() == ElevatorDirection.UP) {
            upQueue.offer(request);
        } else {
            downQueue.offer(request);
        }
        processRequests();
    }

    private void processRequests() {
        if (state == ElevatorState.IDLE) {
            if (!upQueue.isEmpty()) {
                state = ElevatorState.MOVING_UP;
                moveToFloor(upQueue.poll().getRequestedFloor());
            } else if (!downQueue.isEmpty()) {
                state = ElevatorState.MOVING_DOWN;
                moveToFloor(downQueue.poll().getRequestedFloor());
            }
        }
    }

    private void moveToFloor(int targetFloor) {
        System.out.println("Elevator moving from floor " + currentFloor + " to " + targetFloor);
        this.currentFloor = targetFloor;
        // After reaching the floor, set the state to IDLE and process next request
        this.state = ElevatorState.IDLE;
        processRequests();

    }
}

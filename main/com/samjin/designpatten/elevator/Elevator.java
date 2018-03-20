package com.samjin.designpatten.elevator;

import java.util.List;

public class Elevator {

    private Direction direction;

    private List<ElevatorButton> button;
    private List<Integer> upStops; // need sorting.
    private List<Integer> downStops; // need sorting.
    private int currentLevel;
    private Status status;

    public Elevator(){

    }

    public void handleExternalRequest(ExternalRequest req){

    }

    public void handleInternalRequest(InternlRequest req){

    }

    public boolean checkWeight(){
        return true;
    }

    public void openGate(){

    }

    public void closeGate(){

    }

    private boolean isRequestValid(InternlRequest req){
        return true;
    }

    /**
     *
     * public class Elevator implement Runnable
     *
     * while(true){
     *     if(hasRequest){
     *          operating();
     *     }else{
     *         thread.sleep();
     *     }
     * }
     */
}

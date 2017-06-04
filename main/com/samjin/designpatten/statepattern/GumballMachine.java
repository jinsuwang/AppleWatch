package com.samjin.designpatten.statepattern;

/**
 * Created by sjjin on 5/31/17.
 */
public class GumballMachine {

    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state;
    int count;

    public GumballMachine( int numberGumball ){

        //  initialize state for machine.
        soldOutState = new SoldoutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldoutState(this);

        this.count = numberGumball;

        if(count > 0 ){
            state = noQuarterState;
        }else{
            state = soldOutState;
        }
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuarter();
    }

    public void turnCrank(){
        state.turnCrank();
    }

    public void setState(State state){
        this.state = state;
    }

    public void realeaseBall(){
        System.out.println("A gumball comes rolling out the slot...");
        if(count != 0){
            count -= 1;
        }
    }
}

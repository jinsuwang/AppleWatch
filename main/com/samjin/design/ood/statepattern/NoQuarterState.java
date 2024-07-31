package com.samjin.design.ood.statepattern;


/**
 * Created by sjjin on 5/31/17.
 */
public class NoQuarterState implements State {

    GumballMachine gumballMachine;

    public NoQuarterState( GumballMachine gumballMachine ){
        this.gumballMachine = gumballMachine;
    }


    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter.");
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}

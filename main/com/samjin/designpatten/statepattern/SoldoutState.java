package com.samjin.designpatten.statepattern;

/**
 * Created by sjjin on 5/31/17.
 */
public class SoldoutState implements State {

    GumballMachine gumballMachine;

    public SoldoutState( GumballMachine gumballMachine ){
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {

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

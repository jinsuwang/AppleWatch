package com.samjin.design.ood.statepattern;

/**
 * Created by sjjin on 5/31/17.
 */
public class SoldState implements State {


    GumballMachine gumballMachine;

    public SoldState( GumballMachine gumballMachine ){
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

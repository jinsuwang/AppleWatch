package com.samjin.design.ood.statepattern;

/**
 * Created by sjjin on 5/31/17.
 */
public interface State {

    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}

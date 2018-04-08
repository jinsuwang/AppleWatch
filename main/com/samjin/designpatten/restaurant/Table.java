package com.samjin.designpatten.restaurant;

/**
 * Created by sjjin on 3/25/18.
 */
public class Table {

    private boolean available;
    private int capacity;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getCapacity() {
        return capacity;
    }
}

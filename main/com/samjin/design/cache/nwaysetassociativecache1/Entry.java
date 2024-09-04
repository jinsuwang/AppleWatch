package com.samjin.design.cache.nwaysetassociativecache1;

import java.sql.Timestamp;

public class Entry<V> {
    public V value;
    public Timestamp timestamp;
    public int tag;
    public boolean occupied;

    public Entry(){
        this.value = null;
        this.timestamp = null;
        this.tag = 0;
        this.occupied = false;
    }

    public Entry(V value, Timestamp timestamp, int tag, boolean occupied) {
        this.value = value;
        this.timestamp = timestamp;
        this.tag = tag;
        this.occupied = occupied;
    }

    public V getValue(){
        return value;
    }

    public Timestamp getTimestamp(){
        return timestamp;
    }

    public int getTag() {
        return tag;
    }

    /**
     * @return the occupied
     */
    public boolean isOccupied() {
        return occupied;
    }

}

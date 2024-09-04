package com.samjin.design.cache.nwaysetassociativecache1;

import java.sql.Timestamp;

public class NWayCache<K, V> implements Cache<K,V>{

    private Entry<V> [] entries;
    private int associativity;
    private int numSets;
    private Policy<V> replacementPolicy = new LRUPolicy<>();

    public NWayCache(int associativity, int cacheSize, int blockSize, Policy<V> evictionPolicy) {
        this(associativity, cacheSize/blockSize, evictionPolicy);
    }

    public NWayCache(int associativity, int numSets, Policy<V> evictionPolicy) {
        this.associativity = associativity;
        this.numSets = numSets;
        this.entries =  (Entry<V>[]) new Entry[associativity * numSets];
        for (int i = 0; i < entries.length; i++) {
            entries[i] = new Entry<>();
        }
        if (evictionPolicy != null) {
            this.replacementPolicy = evictionPolicy;
        }
    }


    @Override
    public V get(K key) {
        int hashKey = Utility.hash(key);
        int startIndex = Utility.getStartIndex(hashKey, numSets, associativity);
        int endIndex = Utility.getEndIndex(startIndex, associativity);

        for (int i = startIndex; i <= endIndex; i++) {
            if (entries[i].occupied && entries[i].tag == hashKey) {
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
                entries[i].timestamp = currentTime;
                return entries[i].value;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {

        int hashKey = Utility.hash(key);
        int startIndex = Utility.getStartIndex(hashKey, numSets, associativity);
        int endIndex = Utility.getEndIndex(startIndex, associativity);

        Timestamp currentTime = new Timestamp(System.nanoTime());

        Entry<V> newEntry = new Entry<V>(value, currentTime, hashKey, false);
        //If entry is already present
        for (int i = startIndex; i <= endIndex; i++) {
            if (entries[i].occupied && entries[i].tag == newEntry.tag) {
                entries[i] = newEntry;
                entries[i].occupied = true;
                return;
            }
        }
        //If there is a line available
        for (int i = startIndex; i <= endIndex; i++) {
            if (!entries[i].occupied) {
                entries[i] = newEntry;
                entries[i].occupied = true;
                return;
            }
        }
        //If eviction will be required
        int evictIndex = replacementPolicy.evictEntryIndex(entries, startIndex, endIndex);
        entries[evictIndex] = newEntry;
        entries[evictIndex].occupied = true;
    }
}

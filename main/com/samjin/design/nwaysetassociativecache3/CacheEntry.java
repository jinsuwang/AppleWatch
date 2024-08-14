package com.samjin.design.nwaysetassociativecache3;

public class CacheEntry<K, V> {

    K key;
    V value;
    long accessTime; // For LRU
    int frequency;   // For LFU

    public CacheEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.accessTime = System.nanoTime();
        this.frequency = 1;
    }
}

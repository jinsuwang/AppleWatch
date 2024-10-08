package com.samjin.design.cache.nwaysetassociativecache1;

public interface Cache<K,V> {

    V get(K key);

    void put(K key, V value);
}

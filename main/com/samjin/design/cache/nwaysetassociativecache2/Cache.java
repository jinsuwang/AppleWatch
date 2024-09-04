package com.samjin.design.cache.nwaysetassociativecache2;

public interface Cache<K, V, M> {
    V get(final K key);
    void put(final K key, final V vale);
}

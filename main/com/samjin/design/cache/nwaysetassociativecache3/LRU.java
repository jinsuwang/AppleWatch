package com.samjin.design.cache.nwaysetassociativecache3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class LRU<K, V> implements EvictionPolicy<K, V>  {
    @Override
    public void onAccess(CacheEntry<K, V> entry) {
        entry.accessTime = System.nanoTime();
    }

    @Override
    public K evict(Map<K, CacheEntry<K, V>> set) {
        return Collections.min(set.entrySet(),
                Comparator.comparingLong(e -> e.getValue().accessTime)).getKey();
//        return set.keySet().iterator().next();
    }
}

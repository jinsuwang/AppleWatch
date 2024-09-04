package com.samjin.design.cache.nwaysetassociativecache3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

class LFU<K, V> implements EvictionPolicy<K, V> {
    @Override
    public void onAccess(CacheEntry<K, V> entry) {
        entry.frequency++;
    }

    @Override
    public K evict(Map<K, CacheEntry<K, V>> set) {
        return Collections.min(set.entrySet(),
                Comparator.comparingInt(e -> e.getValue().frequency)).getKey();

    }
}

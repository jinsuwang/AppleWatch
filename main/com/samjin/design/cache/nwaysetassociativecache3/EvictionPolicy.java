package com.samjin.design.cache.nwaysetassociativecache3;

import java.util.Map;

public interface EvictionPolicy<K, V> {

    void onAccess(CacheEntry<K, V> entry);
    K evict(Map<K, CacheEntry<K, V>> set);

}

package com.samjin.design.nwaysetassociativecache3;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NWaySetAssociativeCache<K, V> {

    private final int numSets;
    private final int setSize;
    private final List<Map<K, CacheEntry<K, V>>> sets;
    private final EvictionPolicy<K, V> evictionPolicy;

    public NWaySetAssociativeCache(int numSets, int setSize, EvictionPolicy<K, V> evictionPolicy) {
        this.numSets = numSets;
        this.setSize = setSize;
        this.evictionPolicy = evictionPolicy;
        this.sets = new ArrayList<>(numSets);
        for (int i = 0; i < numSets; i++) {
            sets.add(new LinkedHashMap<>(setSize, 0.75f, true));
        }
    }

    private int getSetIndex(K key) {
        return Math.abs(key.hashCode()) % numSets;
    }

    public V get(K key) {
        int setIndex = getSetIndex(key);
        Map<K, CacheEntry<K, V>> set = sets.get(setIndex);
        if (set.containsKey(key)) {
            CacheEntry<K, V> entry = set.get(key);
            evictionPolicy.onAccess(entry);
            return entry.value;
        }
        return null;
    }


    public void put(K key, V value) {
        int setIndex = getSetIndex(key);
        Map<K, CacheEntry<K, V>> set = sets.get(setIndex);
        if (set.containsKey(key)) {
            CacheEntry<K, V> entry = set.get(key);
            entry.value = value;
            evictionPolicy.onAccess(entry);
        } else {
            if (set.size() >= setSize) {
                K keyToEvict = evictionPolicy.evict(set);
                set.remove(keyToEvict);
            }
            CacheEntry<K, V> newEntry = new CacheEntry<>(key, value);
            set.put(key, newEntry);
        }
    }

}

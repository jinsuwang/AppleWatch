package com.samjin.design.cache.nwaysetassociativecache1;

public interface CacheFactory {

    public static <K,V> Cache<K,V> newCache(int associativity, int cacheSize, int blockSize, Policy<V> evictionPolicy){
        return new NWayCache<K,V>(associativity, cacheSize, blockSize, evictionPolicy);
    }

    public static <K,V> Cache<K,V> newCache(int associativity, int numSets, Policy<V> evictionPolicy){
        return new NWayCache<K,V> (associativity, numSets, evictionPolicy);
    }


}

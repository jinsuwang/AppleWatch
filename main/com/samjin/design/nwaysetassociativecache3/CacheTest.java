package com.samjin.design.nwaysetassociativecache3;

public class CacheTest {
    public static void main(String[] args) {
        EvictionPolicy<Integer, String> lruPolicy = new LRU<>();
        NWaySetAssociativeCache<Integer, String> lruCache =
                new NWaySetAssociativeCache<>(4, 2, lruPolicy);

        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.get(1);
        lruCache.put(3, "three");
        lruCache.put(4, "four");

        System.out.println("LRU Cache:");
        System.out.println(lruCache.get(1)); // Should print "one"
        System.out.println(lruCache.get(2)); // Should print null if evicted

        EvictionPolicy<Integer, String> lfuPolicy = new LFU<>();
        NWaySetAssociativeCache<Integer, String> lfuCache =
                new NWaySetAssociativeCache<>(4, 2, lfuPolicy);

        lfuCache.put(1, "one");
        lfuCache.put(2, "two");
        lfuCache.get(1);
        lfuCache.get(1);
        lfuCache.put(3, "three");
        lfuCache.put(4, "four");

        System.out.println("LFU Cache:");
        System.out.println(lfuCache.get(1)); // Should print "one"
        System.out.println(lfuCache.get(2)); // Should print null if evicted
    }
}
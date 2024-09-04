package com.samjin.design.cache.nwaysetassociativecache1;

public interface Policy<V> {

    int evictEntryIndex(Entry<V>[] entries, int startIndex, int endIndex);
}

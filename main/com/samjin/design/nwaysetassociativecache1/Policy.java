package com.samjin.design.nwaysetassociativecache1;

public interface Policy<V> {

    int evictEntryIndex(Entry<V>[] entries, int startIndex, int endIndex);
}

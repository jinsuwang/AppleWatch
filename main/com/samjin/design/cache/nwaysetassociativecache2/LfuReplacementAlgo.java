package com.samjin.design.cache.nwaysetassociativecache2;

public class LfuReplacementAlgo<K, V> implements ReplacementAlgo<K, V, Long>{


    @Override
    public int compare(CacheElement<K, V, Long> current, CacheElement<K, V, Long> candidate) {
        return Long.compare(current.getMetadata(), candidate.getMetadata());
    }

    @Override
    public void onPut(CacheElement<K, V, Long> element) {
        onGet(element);
    }

    @Override
    public void onGet(CacheElement<K, V, Long> element) {
        if (element.getMetadata() == null) {
            element.setMetadata(1L);
        } else {
            element.setMetadata(element.getMetadata() + 1L);
        }
    }
}

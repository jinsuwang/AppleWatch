package com.samjin.design.nwaysetassociativecache2;
import java.util.Comparator;
public interface ReplacementAlgo<K,V,M> extends Comparator<CacheElement<K,V,M>>{
    void onPut(CacheElement<K,V,M> element);
    void onGet(CacheElement<K,V,M> element);
}

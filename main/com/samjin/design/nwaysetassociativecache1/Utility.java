package com.samjin.design.nwaysetassociativecache1;

public class Utility {

    public static int getStartIndex(int hashKey, int numSets, int associativity){
        int startIndex = (hashKey % numSets) * associativity;
        return startIndex;
    }

    public static int getEndIndex (int startIndex, int associativity){
        int endIndex = startIndex + associativity - 1;
        return endIndex;
    }

    public static int hash(Object key){
        return key.hashCode() * 37 + 17;
    }
}

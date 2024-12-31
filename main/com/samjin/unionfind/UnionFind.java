package com.samjin.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {

    private Map<String, String> parent;

    public UnionFind(){
        parent = new HashMap<>();
    }

    public String find(String s){
        if (!parent.containsKey(s)) {
            parent.put(s, s);
        }
        if (!s.equals(parent.get(s))) {
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    public void union(String x, String y){
        String rootX = find(x);
        String rootY = find(y);
        if (!rootX.equals(rootY)){
            parent.put(rootX, rootY);
        }
    }
}

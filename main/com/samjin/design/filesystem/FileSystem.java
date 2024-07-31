package com.samjin.design.filesystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    Map<String, Integer> map;
    public FileSystem() {
        map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        if (map.containsKey(path)) return false;
        int idx = path.lastIndexOf('/');
        if (idx == -1) return false;
        if (idx == 0) {
            map.put(path, value);
        } else {
            String parent = path.substring(0, idx);
            if (map.containsKey(parent)) {
                map.put(path, value);
            } else {
                return false;
            }
        }
        return true;
    }

    public int get(String path) {
        Integer v = map.get(path);
        return v == null ? -1 : v.intValue();
    }

}

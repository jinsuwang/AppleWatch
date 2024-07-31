package com.samjin.design.logstoragesystem;

import java.util.*;

class LogSystem {
    String min = "2000:01:01:00:00:00";
    String max = "2017:12:31:23:59:59";
    private HashMap<String, Integer> map;
    private TreeMap<String, LinkedList<Integer>> logs;

    public LogSystem() {
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        logs = new TreeMap<>();
    }

    // O(log(n))
    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp)) {
            logs.put(timestamp, new LinkedList<>());
        }

        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start = s.substring(0, index) + min.substring(index);
        String end = e.substring(0, index) + max.substring(index);

        /**
         * O(1) Time Complexity
         * public NavigableMap<K,V> subMap(
         *      K fromKey,
         *      boolean fromInclusive,
         *      K toKey,
         *      boolean toInclusive
         * )
         */
        Map<String, LinkedList<Integer>> sub = logs.subMap(start, true, end, true);

        LinkedList<Integer> res = new LinkedList<>();
        for (LinkedList<Integer> list : sub.values()) {
            res.addAll(list);
        }

        return res;
    }
}
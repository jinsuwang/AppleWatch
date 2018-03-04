package com.samjin.hapmap;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagram {


    // TLE solution
    public List<List<String>> groupAnagramsTLE(String[] strs) {

        List<List<String>> res = new ArrayList<List<String>>();

        Map<String, List<String>> map = new HashMap<String,List<String>>();

//        for(String s : strs){
//            String sorted  = Stream.of(s.split("")).sorted().collect(Collectors.joining());
//            if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
//            map.get(sorted).add(s);
//        }

        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String s = String.valueOf(arr);
            if (!map.containsKey(s)) {
                ArrayList<String> list = new ArrayList<String>();
                map.put(s, list);
            }
            map.get(s).add(strs[i]);
        }

        res.addAll(map.values());
        return res;
    }


}

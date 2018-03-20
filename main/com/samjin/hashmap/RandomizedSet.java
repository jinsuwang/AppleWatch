package com.samjin.hashmap;

import java.util.*;

/**
 * Created by sjjin on 9/6/17.
 */
class RandomizedSet {

    private HashMap<Integer,Integer> map;
    private List<Integer> list;
    private Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();

    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        // put new value to the last.
        map.put(val, list.size());
        list.add(val);
        random = new Random();
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int index = map.get(val);

        // if not last item
        if(index != list.size() - 1){
            map.put(list.get(list.size()-1), index);
            list.set(index, list.get(list.size()-1));
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}


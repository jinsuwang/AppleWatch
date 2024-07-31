package com.samjin.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sjjin on 9/6/17.
 */
public class SortCharactersByFrequency {

    private class Pair{
        Integer frequency;
        Character charactor;

        Pair(Integer frequency, char charactor){
            this.frequency = frequency;
            this.charactor = charactor;
        }

        @Override
        public String toString() {
            return String.format("Charector is %s, Frequency is %s", this.charactor, this.frequency);
        }
    }

    public String frequencySort(String s) {

        PriorityQueue<Pair> pq = new PriorityQueue<>( (a,b) -> (b.frequency - a.frequency)
//            new Comparator<Pair>() {
//                @Override
//                public int compare(Pair p1, Pair p2) {
//                    // change to max heap
//                    return -1 * p1.frequency.compareTo(p2.frequency);
//                }
//            }
        );

        // Create counter map
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++ ){
            char currChar = s.charAt(i);
            if(map.containsKey(currChar)){
                map.put(currChar, map.get(currChar)+1);
            }else{
                map.put(currChar, 1);
            }
        }

        for( char e : map.keySet()){
            Pair p = new Pair(map.get(e), e);
            pq.offer(p);
        }


        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair tmpPair = pq.poll();
            sb.append(formString(tmpPair));
        }
        return sb.toString();
    }


    private String formString(Pair pair){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < pair.frequency;i++){
            sb.append(pair.charactor);
        }
        return sb.toString();
    }
}

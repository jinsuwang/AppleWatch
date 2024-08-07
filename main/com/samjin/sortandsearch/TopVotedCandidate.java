package com.samjin.sortandsearch;

import java.util.HashMap;

class TopVotedCandidate {

    HashMap<Integer,Integer> time=new HashMap<>();

    int[] arr = null;

    public TopVotedCandidate(int[] persons, int[] times) {

        int maxi=Integer.MIN_VALUE;
        arr=times;
        HashMap<Integer,Integer>mp=new HashMap<>();
        int maxperson=0;
        for(int i=0;i<times.length;i++){

            if(!mp.containsKey(persons[i])){
                mp.put(persons[i],1);
            }
            else mp.put(persons[i],mp.get(persons[i])+1);

            if(maxi<mp.get(persons[i])){
                time.put(times[i],persons[i]);
                maxi=mp.get(persons[i]);
                maxperson=persons[i];
            }
            else if(maxi==mp.get(persons[i])){
                time.put(times[i],persons[i]);
                maxperson=persons[i];
            }
            else{
                time.put(times[i],maxperson);
            }
        }
    }

    public int q(int K) {
        int start = 0;
        int end = arr.length-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == K)
                return time.get(arr[mid]);
            else if (arr[mid] < K)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return time.get(arr[end]);

    }
}

package com.samjin.array;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length == 0 || cost.length == 0) return -1;

        int total = 0;
        int curr = 0;
        int start = 0;


        for(int i = 0; i < cost.length; i++){
            curr += gas[i] - cost[i];

            if(curr < 0) {
                start = i + 1;
                curr = 0;
            }

            total += gas[i] - cost[i];
        }
        // 如果总的油量>=0那么一定可以走完全程
        return total >= 0 ? start : -1;
    }
}

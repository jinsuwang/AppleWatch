package com.samjin.greedy;

import java.util.Arrays;

public class MinimumNumberOfCoinsToBeAdded {


    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int limit = 0;
        int res = 0;
        int i = 0;
        while (limit < target) {
            if (i == coins.length || limit + 1 < coins[i]){
                res++;
                limit += limit + 1;
            }else{
                limit += coins[i];
                i++;
            }
        }
        return res;
    }
}

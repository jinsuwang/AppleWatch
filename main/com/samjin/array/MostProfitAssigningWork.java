package com.samjin.array;

import com.samjin.stack.HitCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostProfitAssigningWork {


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0, j = 0, best = 0;
        List<HitCounter.Pair<Integer>> temp = new ArrayList<>();

        for (int i = 0; i < difficulty.length; ++i) {
            temp.add(new HitCounter.Pair<>(difficulty[i], profit[i]));
        }

        temp.sort((a, b) -> a.getKey() - b.getKey());
        Arrays.sort(worker);

        for (int work : worker) {
            while (j < worker.length && work >= temp.get(j).getKey()) {
                best = Math.max(best, temp.get(j++).getValue());
            }

            res += best;
        }

        return res;
    }
}

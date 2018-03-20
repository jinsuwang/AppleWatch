package com.samjin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        res.add(Arrays.asList(new Integer[]{1}));
        if(numRows == 1) return res;
        res.add(Arrays.asList(new Integer[]{1,1}));
        if(numRows == 2) return res;

        for(int i = 3; i <= numRows; i++){
            Integer[] curr = new Integer[i];
            curr[0] = 1;
            curr[i-1] = 1;
            for(int j = 1; j < i-1; j++){
                curr[j] = res.get(i-2).get(j-1) + res.get(i-2).get(j);
            }
            res.add(Arrays.asList(curr));
        }

        return res;

    }

    public List<Integer> getRow(int rowIndex){
        List<Integer> last = new ArrayList<>();
        last.add(1);
        if(rowIndex == 0) return last;
        for(int i = 1; i <=rowIndex; i++ ) {
            List<Integer> next = new ArrayList<>();
            next.add(1);
            for(int j = 1;j < i; j++){
                next.add(last.get(j)+last.get(j-1));
            }
            next.add(1);
            last = next;
        }
        return last;
    }
}

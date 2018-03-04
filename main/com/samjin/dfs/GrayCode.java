package com.samjin.dfs;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n < 1) return res;
        res.add(1);
        for(int i = 1; i < n; i++ ){
            int high = 1 << i; int j = res.size()-1;
            for( int k = j; k >=0; k-- ){
                res.add(res.get(k) + high);
            }
        }
        return res;
    }
}

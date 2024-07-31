package com.samjin.sortandsearch;

import com.samjin.util.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) return res;

        Collections.sort(intervals, (Interval i1, Interval i2)->{
                return i1.start - i2.start;
        });

        Interval curr = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++ ){
            Interval newOne = intervals.get(i);

            if(newOne.start > curr.end){ // need merge
                res.add(curr);
                curr = newOne;
            }else{
                if(newOne.end > curr.end) curr.end = newOne.end;
            }
        }
        res.add(curr);
        return res;
    }
}

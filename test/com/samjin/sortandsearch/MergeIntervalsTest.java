package com.samjin.sortandsearch;

import com.samjin.util.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MergeIntervalsTest {


    MergeIntervals ins = new MergeIntervals();

    @Test
    public void merge() {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        List<Interval> res = ins.merge(intervals);

        printInterval(res);

    }

    private void printInterval(List<Interval> res) {
        StringBuilder sb = new StringBuilder();
        res.forEach( e -> sb.append( "(" + e.start + "," + e.end + ")"));
        System.out.println(sb.toString());
    }
}
package com.samjin.dp;

import org.junit.Test;

public class BestTimeToSellStockTest {

    BestTimeToSellStock ins = new BestTimeToSellStock();

    @Test
    public void test1(){
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(ins.maxProfit(prices));

    }

}
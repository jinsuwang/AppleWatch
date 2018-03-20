package com.samjin.dp;

public class BestTimeToSellStock {

    /**
     * Can only have one transaction
     */
    public int maxProfit(int[] prices) {

        if(prices == null ||prices.length < 2) return 0;

        int minPrice = prices[0];

        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            profit = Math.max(prices[i] - minPrice, profit);
            if(prices[i] < minPrice) minPrice=prices[i];
        }

        return profit;
    }


    /**
     * Can have as many as transaction you want
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for( int i = 1; i < prices.length; i++ ){
            if( prices[i] > prices[i-1] ){
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}

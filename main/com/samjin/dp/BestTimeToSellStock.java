package com.samjin.dp;

public class BestTimeToSellStock {

    /**
     * Can only have one transaction
     */
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) return 0;

        int minPrice = prices[0];

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - minPrice, profit);
            if (prices[i] < minPrice) minPrice = prices[i];
        }

        return profit;
    }


    /**
     * Can have as many as transaction you want
     */
    public int maxProfit2(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }


    /**
     * Can have most two transaction
     */

    public int maxProfit3(int[] prices) {
        int len = prices.length;

        if (prices.length == 0 ) return 0;

        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++){
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len-1][4];
    }


    /**
     * Can have most K transaction
     *
     * @param prices
     * @return
     */
    public int maxProfit4(int k, int[] prices) {

        if (prices.length == 0) return 0;

        // [天数][交易次数][是否持有股票]
        int len = prices.length;
        int[][][] dp = new int[len][k + 1][2];

        // dp数组初始化
        // 初始化所有的交易次数是为确保 最后结果是最多 k 次买卖的最大利润
        for (int i = 0; i <= k; i++) {
            dp[0][i][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                // dp方程, 0表示不持有/卖出, 1表示持有/买入
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    /**
     * Can have as many as transactions you want with fee.
     */
    public int maxProfit5(int[] prices) {
        return 0;

    }

    /**
     * Can have as many as transactions as with cool down
     * @param prices
     * @return
     */
    public int maxProfit6(int[] prices) {
        return 0;

    }

}




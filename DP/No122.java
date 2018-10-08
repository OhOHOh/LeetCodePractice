package DP;

public class No122 {
    public int maxProfit(int[] prices) {
        int result_max = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i+1] > prices[i]) {
                result_max += prices[i+1] - prices[i];
            }
        }

        return result_max;
    }
}

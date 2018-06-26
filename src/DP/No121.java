package DP;

public class No121 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        if (prices.length == 2) {
            return (prices[1] - prices[0]) > 0 ? prices[1] - prices[0] : 0;
        }
        int result_max = 0;
        int min_i = prices[0]; // 在第 i 个元素之前的最小值（不包括 i）
        int max_i = 0;        // 第i个元素减去 min_i

        for (int i = 1; i < prices.length; i++) {
            if (min_i >= prices[i]) {
                max_i = 0;
                min_i = prices[i];
            } else {
                max_i = prices[i] - min_i;
                result_max = Math.max(result_max, max_i);
            }
        }
        return result_max;
    }
}

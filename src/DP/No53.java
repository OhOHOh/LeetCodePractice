package DP;

public class No53 {
    public static void main(String args[]) {
        System.out.println("Hello World");
    }

    public static int maxSubArrayDP(int[] nums) {
        /**
         * 动态规划
         * dp[i] 表示 以 num[i] 为结尾的具有最大和的 连续子序列  的和
         */
        int len = nums.length;
        int[] dp = new int[len];
        int max = nums[0];
        dp[0] = max;

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = max > dp[i] ? max : dp[i];
        }

        return max;
    }

    public static int maxSubArray(int[] nums) {
        /**
         * 暴力搜索
         */
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, maxT(nums, i, len));
        }

        return max;
    }// maxSubArray
    private static int maxT(int[] nums, int start, int len) {
        if (start == len-1) {
            return nums[start];
        }
        int sum = nums[start];
        int max = sum;

        for (int i = start+1; i < len; i++) {
            sum += nums[i];
            max = sum > max ? sum : max;
        }

        return max;
    }
}

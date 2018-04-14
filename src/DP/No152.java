package DP;

public class No152 {
    public static void main(String args[]) {
        int[] nums = {-4, -3, 2, -6};

        System.out.println(maxProductDP2(nums));
    }

    public int maxProduct(int[] nums) {
        int len = nums.length;
//        int left=len, right=len;
//        int leftPro = 1, rightPro = 1, midPro = 1;
//
//        for (int i = 0; i < len; i++) {
//            if (nums[i] > 0) {
//
//            }
//        }
        int posMax = nums[0];
        int negMax = nums[0];
        int ret = nums[0];

        for (int i = 1; i < len; i++) {
            int tempPosMax = posMax;
            int tempNegMax = negMax;
            posMax = Math.max(nums[i], Math.max(nums[i]*tempPosMax, nums[i]*tempNegMax));
            negMax = Math.min(nums[i], Math.min(nums[i]*tempPosMax, nums[i]*tempNegMax));
            ret = Math.max(ret, posMax);
        }
        return ret;
    }

    public static int maxProductDP(int[] nums) {
        /**
         * 动态规划, dp[i][0] -> 以i为结尾的乘积最小值, dp[i][1] -> 以i为结尾的乘积最大值
         * 有问题！！！
         */
        int len = nums.length;

        int[][] dp = new int[len][2];
        int max = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] == 0) {
                dp[i][0] = 0;
                dp[i][1] = 0;
                continue;
            }
            int t1 = dp[i-1][0] * nums[i];
            int t2 = dp[i-1][1] * nums[i];
            dp[i][0] = Math.min(t1, t2);
            dp[i][1] = Math.max(t1, t2);
            if (t1 == 0 && t2 == 0) {
                dp[i][0] = nums[i];
                dp[i][1] = nums[i];
                continue;
            }
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }

    private static int maxProductDP2(int[] nums) {
        /**
         * 动态规划, dp[i][0] -> 以i为结尾的乘积最小值, dp[i][1] -> 以i为结尾的乘积最大值
         */
        int len = nums.length;
        int[][] dp = new int[len][2];
        int max = nums[0];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i++) {
            int t1 = dp[i-1][0] * nums[i];
            int t2 = dp[i-1][1] * nums[i];
            dp[i][0] = Math.min(nums[i], Math.min(t1, t2));
            dp[i][1] = Math.max(nums[i], Math.max(t1, t2));

            max = Math.max(max, dp[i][1]);
        }

        return max;
    }
}

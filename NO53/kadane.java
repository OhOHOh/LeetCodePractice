package NO53;

public class kadane {
    public int maxSubArray(int[] nums) {
        int max_so_far = nums[0], max_ending_here = nums[0];

        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(max_ending_here+nums[i] > 0 ? max_ending_here+nums[i]: Integer.MIN_VALUE,
                    max_ending_here);
            max_so_far = Math.max(max_ending_here, max_so_far);
        }

        return max_so_far;
    }
    public static void main(String args[]) {
        No53 test = new No53();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(a));
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int[] dp = new int[len];
        dp[0] = max;

        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1] > 0 ? nums[i] + dp[i-1] : nums[i];
            max = Math.max(max, dp[i]);
        }

        return max;
    }

}

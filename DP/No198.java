import java.util.Scanner;

public class No198 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String[] aes = a.split(" ");
        int[] input = new int[aes.length];
        for (int i = 0; i < aes.length; i++) {
            input[i] = Integer.parseInt(aes[i]);
        }
        System.out.println(rob(input));
    }
    private static int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = dp[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

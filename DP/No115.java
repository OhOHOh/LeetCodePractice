package DP;

public class No115 {
    public int numDistinct(String s, String t) {
        /**
         * DP, dp[i][j]: s 中前 i 个元素组成的子序列中包含了 （ t 中前 j 个元素组成的序列） 的个数
         */
        if (s.length() < t.length()) {
            return 0;
        } else if (s.length() == t.length()) {
            return s.equals(t) ? 1 : 0;
        }

        int[][] dp = new int[t.length()+1][s.length()+1];
        dp[0][0] = 1;
        for (int i = 0; i < t.length()+1; i++) {
            // s 为空
            dp[i][0] = 0;
        }
        for (int j = 0; j < s.length()+1; j++) {
            // t 为空
            dp[0][j] = 1;
        }

        for (int i = 1; i < t.length()+1; i++) {
            for (int j = 1; j < s.length()+1; j++) {
                dp[i][j] = dp[i][j-1] + ((s.charAt(j-1) == t.charAt(i-1)) ? dp[i-1][j-1] : 0);
            }
        }

        return dp[t.length()][s.length()];
    }
}

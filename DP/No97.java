package DP;

public class No97 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "bc";
        String s3 = "babc";
        System.out.println(isInterleave(s1, s2, s3));

    }// main

    public static boolean isInterleave(String s1, String s2, String s3) {
        /**
         * DP, dp[i][j] 代表 s1[0~i-1] 和 s2[0~j-1] 与 s3[0~i+j-1] 匹配了, 并令 dp[0][0] = true
         */
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1+len2 != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[len1+1][len2+1];
        //初始化
        for (int i = 1; i <= len1; i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                dp[i][0] = true;
            }
        }
        for (int i = 1; i <= len2; i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                dp[0][i] = true;
            }
        }
        dp[0][0] = true;


        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if (s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }

        return dp[len1][len2];
    }
}

package DP;

/**
 * scrambled string  扰乱字符串
 */
public class No87 {
    public boolean isScramble(String s1, String s2) {
        /**
         *  DP, 维护 dp[][j][n]: 长度为 n, s1[i~i+n-1] 与 s2[j~j+n-1] 是否 Scramble
         */
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        // 初始化
        for (int i = 0; i <  len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int n = 2; n <= len; n++) { // 长度 n
            for (int i = 0; i < len-n+1; i++) {
                for (int j = 0; j < len-n+1; j++) {
                    // dp[i][j][n] =
                    for (int k = 1; k < n; k++) {
                        dp[i][j][n] |= (dp[i][j][k] && dp[i+k][j+k][n-k]) || (dp[i][j+n-k][k] && dp[i+k][j][n-k]);
                    }
                }
            }
        }

        return dp[0][0][len];
    }
}

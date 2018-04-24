package DP;

public class No72 {
    public int minDistance(String word1, String word2) {
        /**
         * DP, 数组 dp[i][j] = x, 指的是 从 word1[0 ~ i-1] 转换到 word2[0 ~ j-1] 所需的最少操作次数(不包括 i, j)
         */
        if (word2.length() == 0) { // 把 word1 中所有字母都删除
            return word1.length();
        }
        if (word1.length() == 0) { // 在 word1 中添加 word2 中的每一个字母
            return word2.length();
        }
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        //DP
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i][j-1]+1, dp[i-1][j-1]+1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

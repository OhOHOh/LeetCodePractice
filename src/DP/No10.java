package DP;

public class No10 {
    public static void main(String args[]) {
        String s = "aab";
        String p = "c*a*b*";

        System.out.println(isMatchDFS(s, p));
    }


    private boolean isMatchDP(String s, String p) {
        int m = p.length(), n = s.length();
        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {// i -> p
            for (int j = 0; j < n; j++) {// j-> s, 待匹配的
                if (i == 0) {
                    dp[i][j] = j==0;
                } else if (j == 0) {
                    dp[i][j] = p.charAt(i-1)!='*' ? false : dp[i-1][j]||dp[i-2][j];
                } else {
                    if (p.charAt(i-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    } else if (p.charAt(i-1) == '*') {
                        if (i == 1) {
                            dp[i][j] = false;
                        } else {
                            dp[i][j] = dp[i-2][j] ||
                                    dp[i-1][j] ||
                                    (p.charAt(i-2)=='.' || p.charAt(i-2)==s.charAt(j-1)) &&
                                            dp[i][j-1];
                        }
                    } else {
                        dp[i][j] = (s.charAt(j-1)==p.charAt(i-1)) && dp[i-1][j-1];
                    }
                }

            }//for j
        }

        return dp[m-1][n-1];
    }

    private static boolean isMatchDFS(String s, String p) {
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();

        return dfs(chs, 0, chp, 0);
    }
    private static boolean dfs(char[] s, int sIndex, char[] p, int pIndex) {
        if (pIndex >= p.length) {
            return sIndex >= s.length;
        }

        if (pIndex+1 < p.length && p[pIndex+1] == '*') {
            while (sIndex < s.length && (p[pIndex] == '.' || p[pIndex] == s[sIndex])) {
                if (dfs(s, sIndex, p, pIndex+2)) {
                    return true;
                }
                sIndex++;
            }
            return dfs(s, sIndex, p, pIndex+2);

        } else if (sIndex < s.length && (p[pIndex] == '.' || s[sIndex]==p[pIndex])) {
            return dfs(s, sIndex+1, p, pIndex+1);
        }

        return false;
    }
}

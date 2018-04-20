package DP;

public class No62 {
    private static int count = 0;
    private static int[][] next = {
            {0, 1},    //向下
            {1, 0}     //向右
    };


    public static void main(String args[]) {
        System.out.println(uniquePathsDP(23, 12));
        System.out.println(uniquePaths(1, 1));
    }


    public static int uniquePaths(int m, int n) {
        /**
         * m列 * n行, 人从 (1, 1) 开始出发
         * 暴力搜索
         */
        boolean[][] book = new boolean[m+1][n+1];
        dfs(m, n, 1, 1, book);

        return count;
    }
    private static void dfs(int m, int n, int x, int y, boolean[][] book) {
        if (x == m && y == n) {
            count++;
            return;
        }

        for (int i = 0; i < 2; i++) { // 只有 2 种走法, 向下、向右
            int next_x = x + next[i][0];
            int next_y = y + next[i][1];
            // 判断是否 越界、访问过
            if (next_x > m || next_y > n || book[next_x][next_y]) {
                continue;
            }
            book[next_x][next_y] = true;
            dfs(m, n, next_x, next_y, book);
            book[next_x][next_y] = false;
        }
    }

    public static int uniquePathsDP(int m, int n) {
        /**
         * m列 * n行, 人从 (0, 0) 开始出发, 到 (m-1, n-1) 结束
         * DP
         */
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

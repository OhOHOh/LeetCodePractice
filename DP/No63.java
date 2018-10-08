package DP;

public class No63 {
    private static int count = 0;
    private static int[][] next = {
            {0, 1},    //向下
            {1, 0}     //向右
    };

    public static void main(String args[]) {
        int[][] matrix = {
                {1, 0}
        };
        System.out.println(uniquePathsWithObstacles(matrix));
    }// main

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         * m列 * n行, 人 从 (0, 0) 开始出发
         * 暴力搜索, 但是会超时
         */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        boolean[][] book = new boolean[m][n];
        dfs(obstacleGrid, 0,0, m, n, book);

        return count;
    }
    private static void dfs(int[][] obstacleGrid, int x, int y, int m, int n, boolean[][] book) {
        if (x == m-1 && y == n-1) {
            count++;
            return;
        }

        for (int i = 0; i < 2; i++) { // 只有 2 种走法, 向下、向右
            int next_x = x + next[i][0];
            int next_y = y + next[i][1];
            // 判断是否 越界、访问过
            if (next_x > m-1 || next_y > n-1 || book[next_x][next_y] || obstacleGrid[next_x][next_y] == 1) {
                continue;
            }
            book[next_x][next_y] = true;
            dfs(obstacleGrid, next_x, next_y, m, n, book);
            book[next_x][next_y] = false;
        }
    }

    public static int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        /**
         * m列 * n行, 人从 (0, 0) 开始出发, 到 (m-1, n-1) 结束
         * DP
         */
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        int s;
        for (s = 0; s < m; s++) {
            if (obstacleGrid[s][0] == 0) {
                dp[s][0] = 1;
            } else {
                break;
            }
        }
        for (; s < m; s++) {
            dp[s][0] = 0;
        }

        for (s = 0; s < n; s++) {
            if (obstacleGrid[0][s] == 0) {
                dp[0][s] = 1;
            } else {
                break;
            }
        }
        for (; s < n; s++) {
            dp[0][s] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}

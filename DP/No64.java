package DP;

public class No64 {
    private static int count = Integer.MAX_VALUE;
    private final static int[][] next = {
            {0, 1},    //向下
            {1, 0}     //向右
    };


    public static void main(String args[]) {
        int[][] grid = {
                {1}
        };
        System.out.println(minPathSum(grid));
    }


    public static int minPathSum(int[][] grid) {
        /**
         *  grid 网格, 从左上角走到右下角, 求路径之和最小
         */
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] book = new boolean[m][n];
        int step = grid[0][0];
        dfs(grid, 0, 0, m, n, step, book);

        return count;
    }
    private static void dfs(int[][] grid, int x, int y, int m, int n, int step, boolean[][] book) {
        if (x == m-1 && y == n-1) {
            count = Math.min(count, step);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int next_x = x + next[i][0];
            int next_y = y + next[i][1];

            if (next_x > m-1 || next_y > n-1 || book[next_x][next_y] || count < (step+grid[next_x][next_y])) {
                continue;
            }
            book[next_x][next_y] = true;
            dfs(grid, next_x, next_y, m, n, step+grid[next_x][next_y], book);
            book[next_x][next_y] = false;
        }
    }


    public static int minPathSumDP(int[][] grid) {
        /**
         * DP, matrix[i][j] 代表从 (0, 0) 处走到 (i, j) 处的最小路径和, 最终返回 matrix[m-1][n-1]
         */
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];
        matrix[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            matrix[i][0] = matrix[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            matrix[0][i] = matrix[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + grid[i][j];
            }
        }

        return matrix[m-1][n-1];
    }
}

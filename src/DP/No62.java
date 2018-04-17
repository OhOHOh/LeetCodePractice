package DP;

public class No62 {
    private static int count = 0;
    private static int[][] next = {
            {0, 1},    //向下
            {1, 0}     //向右
    };


    public static void main(String args[]) {
        System.out.println(uniquePaths(23, 12));
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
}

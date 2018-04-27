package DP;

public class No85 {
    public int maximalRectangle(char[][] matrix) {
        /**
         *  DP
         *  record[i][0] -> 第 i 行以上的所有矩形中, 所选定的最大矩形的 左边界
         *  record[i][1] -> 第 i 行以上的所有矩形中, 所选定的最大矩形的 右边界
         *  record[i][2] -> 第 i 行以上的所有矩形中, 所选定的最大矩形的 高度
         */
        int m = matrix.length;      // 行
        int n = matrix[0].length;   // 列

        int[][] record = new int[n][3];
        int max = 0;
        for (int i = 0; i < n; i++) {
            record[i][0] = 0;
            record[i][1] = n-1;
            record[i][3] = 1;
        }

        for (int i = 0; i < m; i++) {
            // 每次进入下一行; 在最后计算 最大的面积, 和原值比较, 并取最大值
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int low=j, high=j+1, k=j+1;
                    for (; k < n && matrix[i][k] == '1'; k++) {
                        high = k;
                    }// for 出来之后 matrix[i][high] = '0' or high = n
                    for (k = low; k < high; k++) {
                        record[k][0] = Math.max(low, record[k][0]);
                        record[k][1] = Math.max(high, record[k][1]);
                        record[k][2]++;
                        max = Math.max(max, (record[i][1]-record[i][0])*record[i][2]);
                    }
                    j = high - 1;
                } else {
                    record[j][0] = 0;
                    record[j][1] = n;
                    record[j][2] = 0;
                }
            }
        }

        return max;
    }// maximalRectangle

    public static int maximalRectangleBao(char[][] matrix) {
        /**
         * 暴力搜索
         */
        int m = matrix.length;                      // 行
        int n = m == 0 ? 0 : matrix[0].length;      // 列
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(findOneMax(matrix, i, j), max);
                }
            }
        }

        return max;
    }
    private static int findOneMax(char[][] matrix, int x, int y) {
        /**
         *  给出 (x, y) 求出以它为左上角的最大矩形的面积
         */
        int m = matrix.length;      // 行
        int n = matrix[0].length;   // 列
        int min_width = Integer.MAX_VALUE;
        int max = 0;

        for (int i = x; i < m && matrix[i][y] == '1'; i++) {
            // 每一行
            int width = 1;
            while (y+width < n && matrix[i][y+width] == '1') {
                width++;
            }
            min_width = Math.min(min_width, width);
            max = Math.max(max, (i - x + 1) * min_width);
        }

        return max;
    }
}

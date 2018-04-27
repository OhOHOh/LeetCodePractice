package DP;

public class No84 {
    public static int largestRectangleArea(int[] heights) {
        /**
         * 求柱状图中最大的矩形的面积, 暴力求解
         */
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(findOneMax(heights, i), max);
        }

        return max;
    }
    private static int findOneMax(int[] heights, int x) {
        /**
         * 求以 x 为起点的最大的 矩形面积
         */
        if (heights[x] == 0) {
            return 0;
        }
        int len = heights.length;
        int max_len = 1;
        int high = heights[x];  // 初始化
        int max_area = high * max_len;

        for (int i = x+1; i < len; i++) { // 找出最小的高度
            if (heights[x] != 0) {
                high = Math.min(high, heights[i]);
                max_len++;
                max_area = Math.max(max_area, high*max_len);
            } else {
                break;
            }
        }

        return max_area;
    }
}

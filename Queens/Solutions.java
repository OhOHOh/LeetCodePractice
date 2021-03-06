package Queens;

import java.util.ArrayList;
import java.util.List;

public class Solutions {

    // https://www.cnblogs.com/springfor/p/3870945.html

    public int totalNQueens(int n) {

        int[] sum = {0};
        int[] columnForRow = new int[n];
        dfs2(n, 0, sum, columnForRow);

        return sum[0];
    }

    private void dfs2(int n, int row, int[] sum, int[] columnForRow) {
        if (row == n) {  // 到底了
            sum[0] += 1;
            return;
        }

        for (int i = 0; i < n; i++) { // 一行中的 n 列, 一一尝试
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                dfs2(n, row+1, sum, columnForRow);
            }
        }
    }




    // -----------------------------------------------------------------------------
    public List<List<String>> solveNQueens(int n) {
        // List<String[]> res = new ArrayList<String[]>();
        List<List<String>> res = new ArrayList<List<String>>();
        int[] columnForRow = new int[n];
        dfs1(n, 0, res, columnForRow);

        return res;
    }
    private void dfs1(int n, int row, List<List<String>> res, int[] columnForRow) {
        if (row == n) {  //判断边界, 当前的 行数 等于 n 了, 说明这个排列是可行的, 要打印出来
            // String[] item = new String[n];
            ArrayList<String> item = new ArrayList<String>(n);
            for (int i = 0; i < n; i++) { // 第 i 行
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) { // 对应的第 j 列
                    if (columnForRow[i] == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                item.add(sb.toString());
            }
            res.add(item);
            return;
        }//判断边界
        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;           // 第 row 行的第 i 列放置Q
            if (check(row, columnForRow)) {
                dfs1(n, row+1, res, columnForRow);
            }

        }

    }

    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[i] == columnForRow[row] || Math.abs(columnForRow[row]-columnForRow[i]) == row-i) {
                return false;
            }
        }
        return true;
    }
}

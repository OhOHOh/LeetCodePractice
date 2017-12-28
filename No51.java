import javax.lang.model.element.NestingKind;
import java.util.ArrayList;
import java.util.List;

public class No51 {
    public List<List<String>> solveNQueens(int n) {
        // List<String[]> res = new ArrayList<String[]>();
        List<List<String>> res = new ArrayList<List<String>>();
        int[] columnForRow = new int[n];
        dfs(n, 0, res, columnForRow);

        return res;
    }

    private void dfs(int n, int row, List<List<String>> res, int[] columnForRow) {
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
                dfs(n, row+1, res, columnForRow);
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


    public static void main(String[] args) {
        No51 test = new No51();

    }
}

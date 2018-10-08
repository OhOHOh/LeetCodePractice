package Queens;

public class No52 {
     private int sum = 100;

    public int totalNQueens(int n) {

        int[] sum = {0};
        int[] columnForRow = new int[n];
        dfs(n, 0, sum, columnForRow);

        return sum[0];
    }

    private void dfs(int n, int row, int[] sum, int[] columnForRow) {
        if (row == n) {  // 到底了
            sum[0] += 1;
            return;
        }

        for (int i = 0; i < n; i++) { // 一行中的 n 列, 一一尝试
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                dfs(n, row+1, sum, columnForRow);
            }
        }
    }

    private int dfs2(int n, int row, int sum, int[] columnForRow) {
        if (row == n) {
            sum++;
            return sum;
        }

        for (int i = 0; i < n; i++) {
            columnForRow[row] = i;
            if (check(row, columnForRow)) {
                sum = dfs2(n, row+1, sum, columnForRow); //当 row == n 来考虑
            }
        }
        return sum;
    }

    private boolean check(int row, int[] columnForRow) {
        for (int i = 0; i < row; i++) {
            if (columnForRow[row] == columnForRow[i] || Math.abs(columnForRow[row]-columnForRow[i]) == row-i) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        No52 test = new No52();
        int n = 3;
        System.out.println(test.totalNQueens(n));
    }

}

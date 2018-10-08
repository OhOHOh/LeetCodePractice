import java.util.ArrayList;
import java.util.List;

public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {  // m * n
        List<Integer> result = new ArrayList<>();
        if (matrix.length ==0) {
            return result;
        }
        int m = matrix.length;      // m
        int n = matrix[0].length;   // n


        int border = Math.min((m+1)/2, (n+1)/2);
        int i, k=0;
        boolean oper = false;

        while (k < border) {   // 第k次开始，起始点为 (k, k) ,边界: [k, n-k), [k, m-k)
            for (i = k; i < n-k; i++) { // right
                result.add(matrix[k][i]);
                oper = true;
            }
            if (!oper) {
                break;
            }
            oper = false;

            for (i = k+1; i < m-k; i++) { // down
                result.add(matrix[i][n-k-1]);
                oper = true;
            }
            if (!oper) {
                break;
            }
            oper = false;

            for (i = n-k-2; i >= k; i--) { // left
                result.add(matrix[m-k-1][i]);
                oper = true;
            }
            if (!oper) {
                break;
            }
            oper = false;

            for (i = m-k-2; i >= k+1; i--) { // up
                result.add(matrix[i][k]);
                oper = true;
            }
            if (!oper) {
                break;
            }
            k++;
        }

        return result;
    }

    public static void main(String args[]) {
        No54 test = new No54();
        int[][] matrix = {
                {1,2,3,10},
                {4,5,6,11},
                {7,8,9,12}
        };
        System.out.println(test.spiralOrder(matrix));
    }

}

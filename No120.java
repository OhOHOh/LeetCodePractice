import java.util.ArrayList;
import java.util.List;

public class No120 {
    public int min_sum = Integer.MAX_VALUE;

    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len == 1) {
            return triangle.get(0).get(0);
        }

        List<Integer> index = new ArrayList<>();
        index.add(0);
        dfs(1, triangle.get(0).get(0), triangle, index);

        return min_sum;
    }

    public void dfs(int step, int sum, List<List<Integer>> triangle, List<Integer> index) {
        if (step == triangle.size()) {
            min_sum = Math.min(min_sum, sum);
            return;
        }
        for (int i = 0; i < 2; i++) {
            int num = index.get(index.size()-1) + i;
            index.add(num);
            dfs(step+1, sum+triangle.get(step).get(num), triangle, index);
            index.remove(index.size()-1);
//            sum = sum - triangle.get(step).get(num);
        }
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for (int i = triangle.size()-2; i >= 0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int tmp = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, tmp+triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        No120 test = new No120();
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        triangle.add(l1);
        List<Integer> l2 = new ArrayList<>();
        l2.add(10); l2.add(4);
        triangle.add(l2);
        System.out.println(test.minimumTotal(triangle));
    }

}


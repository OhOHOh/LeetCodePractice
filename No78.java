import java.util.ArrayList;
import java.util.List;

public class No78 {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> tmp, int index) {
        result.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            dfs(nums, tmp, i+1);
            tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        No78 test = new No78();
        int[] nums = {1, 2, 3};
        System.out.println(test.subsets(nums));
    }
}

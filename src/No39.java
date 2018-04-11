import java.util.*;

public class No39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int end = candidates.length - 1;
        while (end >= 0) {
            if (candidates[end] <= target) {
                break;
            }
            end--;
        }
        if (end < 0) {
            return result;
        }
        //getResult2(result, new ArrayList<Integer>(), candidates, target, end);

        getResult(result, new ArrayList<Integer>(), candidates, target, 0);

        return result;
    }

    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target > 0) {
            for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target-candidates[i], i);
                cur.remove(cur.size()-1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }
    }
    // 从后往前～
    private void getResult2(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int end) {
        if (target > 0) {
            for (int i = end; i >= 0 && target >= candidates[i]; i--) {
                cur.add(candidates[i]);
                getResult2(result, cur, candidates, target-candidates[i], i);
                cur.remove(cur.size()-1);
            }
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(cur));
        }
    }

    public static void main(String[] args) {
        No39 test = new No39();
        int[] tmp = {1, 2};
        int target = 1;

        System.out.println(test.combinationSum(tmp, target));
    }
}

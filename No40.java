import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        getResult(result, candidates, new ArrayList<Integer>(), target, 0);

        return result;
    }// combinationSum2

    private void getResult(List<List<Integer>> result, int[] candidates, List<Integer> cur, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
        if (target < 0)
            return;

        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            cur.add(candidates[i]);
            getResult(result, candidates, cur, target-candidates[i], i+1);
            cur.remove(cur.size()-1);
        }
    }
}

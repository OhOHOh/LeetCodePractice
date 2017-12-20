package No46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        backtrack(result, new ArrayList<Integer>(), nums, used);

        return result;
    }


    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<Integer>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i>0 && nums[i-1]==nums[i] && !used[i-1]) {
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, used);
            used[i] = false;
            tempList.remove(tempList.size()-1);
        }
    }


    public static void main(String[] args) {
        No47 test = new No47();
        int[] nums = {1, 1, 2};
        System.out.println(test.permuteUnique(nums));
    }
}
